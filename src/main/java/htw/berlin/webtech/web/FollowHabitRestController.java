package htw.berlin.webtech.web;

import htw.berlin.webtech.service.FollowHabitService;
import htw.berlin.webtech.web.api.FollowHabit;
import htw.berlin.webtech.web.api.FollowHabitManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(path = "/api/v1/followHabits")
    public ResponseEntity<Void> createFollowHabit(@RequestBody FollowHabitManipulationRequest request) throws URISyntaxException {
        var followHabit = followHabitService.create(request);
        URI uri = new URI("/api/v1/followHabits/" + followHabit.getId());
        return ResponseEntity.created(uri).build();

    }

}
