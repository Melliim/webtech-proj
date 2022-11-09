package htw.berlin.webtech.web;

import htw.berlin.webtech.web.api.Habit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HabitRestController {

    private List<Habit> habits;

    public HabitRestController() {
        habits = new ArrayList<>();
        habits.add(new Habit(1, "morning routine", "brush teeth, floss, shower", true));
        habits.add(new Habit(2, "quit nic.", "smoke max 4 cig", false));
    }

    @GetMapping(path = "/api/v1/habits")
    public ResponseEntity<List<Habit>> fetchHabits() {
        return ResponseEntity.ok(habits);
    }

}
