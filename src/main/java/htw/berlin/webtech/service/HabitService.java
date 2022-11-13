package htw.berlin.webtech.service;

import htw.berlin.webtech.persistence.Category;
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
    private final HabitTransformer habitTransformer;

    public HabitService(HabitRepository habitRepository, HabitTransformer habitTransformer) {
        this.habitRepository = habitRepository;
        this.habitTransformer = habitTransformer;
    }

    public List<Habit> findAll(){
        List<HabitEntity> habits = habitRepository.findAll();
        return habits.stream()
                .map(habitTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Habit findById(Long id){
        var habitEntity = habitRepository.findById(id);
        return habitEntity.map(habitTransformer::transformEntity).orElse(null);
    }

    public Habit create(HabitManipulationRequest request) {
        var category = Category.valueOf(request.getCategory());
        var habitEntity = new HabitEntity(request.getTitle(), request.getDescription(), request.getFinished(), category);
        habitEntity = habitRepository.save(habitEntity);
        return habitTransformer.transformEntity(habitEntity);
    }

    public Habit update(Long id, HabitManipulationRequest request) {
        var habitEntityOptional = habitRepository.findById(id);
        if (habitEntityOptional.isEmpty()) {
            return null;
        }

        var habitEntity = habitEntityOptional.get();
        habitEntity.setTitle(request.getTitle());
        habitEntity.setDescription(request.getDescription());
        habitEntity.setFinished(request.getFinished());
        habitEntity.setCategory(Category.valueOf(request.getCategory()));
        habitEntity = habitRepository.save(habitEntity);

        return habitTransformer.transformEntity(habitEntity);
    }

    public Boolean deleteById(Long id) {
        if (!habitRepository.existsById(id)) {
            return false;
        }

        habitRepository.deleteById(id);
        return true;
    }


}
