package htw.berlin.webtech.service;

import htw.berlin.webtech.persistence.Category;
import htw.berlin.webtech.persistence.FollowHabitEntity;
import htw.berlin.webtech.persistence.HabitEntity;
import htw.berlin.webtech.web.api.Habit;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class HabitTransformer {

    public Habit transformEntity(HabitEntity habitEntity) {
        var category = habitEntity.getCategory() != null ? habitEntity.getCategory().name() : Category.UNKNOWN.name();
        var followHabitIds = habitEntity.getFollowHabits().stream().map(FollowHabitEntity::getId).collect(Collectors.toList());
        return new Habit(
                habitEntity.getId(),
                habitEntity.getTitle(),
                habitEntity.getDescription(),
                category,
                habitEntity.getFinished(),
                followHabitIds);
    }
}
