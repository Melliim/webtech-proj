package htw.berlin.webtech.service;

import htw.berlin.webtech.persistence.HabitEntity;
import htw.berlin.webtech.persistence.HabitRepository;
import htw.berlin.webtech.web.api.Habit;
import htw.berlin.webtech.web.api.HabitManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabitService {
    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public List<Habit> findAll(){
        List<HabitEntity> habits = habitRepository.findAll();
        return habits.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Habit findById(Long id){
        var habitEntity = habitRepository.findById(id);
        return habitEntity.map(this::transformEntity).orElse(null);
    }

    public Habit create(HabitManipulationRequest request) {
        var habitEntity = new HabitEntity(request.getTitle(), request.getDescription(), request.isFinished());
        habitEntity = habitRepository.save(habitEntity);
        return transformEntity(habitEntity);
    }

    public Habit update(Long id, HabitManipulationRequest request) {
        var habitEntityOptional = habitRepository.findById(id);
        if (habitEntityOptional.isEmpty()) {
            return null;
        }

        var habitEntity = habitEntityOptional.get();
        habitEntity.setTitle(request.getTitle());
        habitEntity.setDescription(request.getDescription());
        habitEntity.setFinished(request.isFinished());
        habitEntity = habitRepository.save(habitEntity);

        return transformEntity(habitEntity);
    }

    public boolean deleteById(Long id) {
        if (!habitRepository.existsById(id)) {
            return false;
        }

        habitRepository.deleteById(id);
        return true;
    }

    private Habit transformEntity(HabitEntity habitEntity) {
        return new Habit(
                habitEntity.getId(),
                habitEntity.getTitle(),
                habitEntity.getDescription(),
                habitEntity.isFinished()
        );
    }
}