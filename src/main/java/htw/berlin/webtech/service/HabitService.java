package htw.berlin.webtech.service;

import htw.berlin.webtech.persistence.HabitEntity;
import htw.berlin.webtech.persistence.HabitRepository;
import htw.berlin.webtech.web.api.Habit;
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
                .map(habitEntity -> new Habit(
                        habitEntity.getId(),
                        habitEntity.getTitle(),
                        habitEntity.getDescription(),
                        habitEntity.isFinished()
                ))
                .collect(Collectors.toList());
    }
}
