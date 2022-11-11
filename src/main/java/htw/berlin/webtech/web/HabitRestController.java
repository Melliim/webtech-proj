package htw.berlin.webtech.web;


import htw.berlin.webtech.service.HabitService;
import htw.berlin.webtech.web.api.Habit;
import htw.berlin.webtech.web.api.HabitManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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

   @GetMapping(path = "/api/v1/habits/{id}")
    public ResponseEntity<Habit> fetchHabitById(@PathVariable Long id){
        var habit = habitService.findById(id);
        return habit != null? ResponseEntity.ok(habit) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/habits")
    public ResponseEntity<Void> createHabit(@RequestBody HabitManipulationRequest request) throws URISyntaxException {
        var habit = habitService.create(request);
        URI uri = new URI("/api/v1/habits/" + habit.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/habits/{id}")
    public ResponseEntity<Habit> updateHabit(@PathVariable Long id, @RequestBody HabitManipulationRequest request){
        var habit = habitService.update(id, request);
        return habit != null? ResponseEntity.ok(habit) : ResponseEntity.notFound().build();

    }

    @DeleteMapping(path = "/api/v1/habits/{id}")
    public ResponseEntity<Void> deleteHabit(@PathVariable Long id) {
        boolean successful = habitService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
