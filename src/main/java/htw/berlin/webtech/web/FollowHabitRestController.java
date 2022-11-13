package htw.berlin.webtech.web;

import htw.berlin.webtech.service.FollowHabitService;
import htw.berlin.webtech.web.api.FollowHabit;
import htw.berlin.webtech.web.api.FollowHabitManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class FollowHabitRestController {

    private final FollowHabitService followHabitService;

    public FollowHabitRestController(FollowHabitService followHabitService) {
        this.followHabitService = followHabitService;
    }

    @GetMapping(path = "/api/v1/followHabits")
    public ResponseEntity<List<FollowHabit>> fetchFollowHabits() {
        return ResponseEntity.ok(followHabitService.findAll());
    }

    @GetMapping(path = "/api/v1/followHabits/{id}")
    public ResponseEntity<FollowHabit> fetchFollowHabitById(@PathVariable Long id){
        var followHabit = followHabitService.findById(id);
        return followHabit != null? ResponseEntity.ok(followHabit) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/followHabits")
    public ResponseEntity<Void> createFollowHabit(@RequestBody FollowHabitManipulationRequest request) throws URISyntaxException {
        var followHabit = followHabitService.create(request);
        URI uri = new URI("/api/v1/followHabits/" + followHabit.getId());
        return ResponseEntity.created(uri).build();

    }

    @PutMapping(path = "/api/v1/followHabits/{id}")
    public ResponseEntity<FollowHabit> updateFollowHabit(@PathVariable Long id, @RequestBody FollowHabitManipulationRequest request){
        var followHabit = followHabitService.update(id, request);
        return followHabit != null? ResponseEntity.ok(followHabit) : ResponseEntity.notFound().build();

    }

    @DeleteMapping(path = "/api/v1/followHabits/{id}")
    public ResponseEntity<Void> deleteFollowHabit(@PathVariable Long id) {
        boolean successful = followHabitService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
