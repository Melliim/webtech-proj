package htw.berlin.webtech.web;

import htw.berlin.webtech.persistence.HabitEntity;
import htw.berlin.webtech.service.HabitService;
import htw.berlin.webtech.web.api.Habit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HabitRestController {

    private final HabitService habitService;

    public HabitRestController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping(path = "/api/v1/habits")
    public ResponseEntity<List<Habit>> fetchHabits() {
        return ResponseEntity.ok(habitService.findAll());
    }

}
