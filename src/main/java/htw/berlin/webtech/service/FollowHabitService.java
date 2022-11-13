package htw.berlin.webtech.service;

        import htw.berlin.webtech.persistence.Category;
        import htw.berlin.webtech.persistence.FollowHabitEntity;
        import htw.berlin.webtech.persistence.FollowHabitRepository;
        import htw.berlin.webtech.persistence.HabitRepository;
        import htw.berlin.webtech.web.api.FollowHabit;
        import htw.berlin.webtech.web.api.FollowHabitManipulationRequest;

        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;
        import java.util.stream.Collectors;

@Service
public class FollowHabitService {

    private final FollowHabitRepository followHabitRepository;
    private final HabitRepository habitRepository;
    private final HabitTransformer habitTransformer;

    public FollowHabitService(FollowHabitRepository followHabitRepository, HabitRepository habitRepository, HabitTransformer habitTransformer) {
        this.followHabitRepository = followHabitRepository;
        this.habitRepository = habitRepository;
        this.habitTransformer = habitTransformer;
    }

    public List<FollowHabit> findAll() {
        List<FollowHabitEntity> followHabits = followHabitRepository.findAll();
        return followHabits.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public FollowHabit findById(Long id){
        var followHabitEntity = followHabitRepository.findById(id);
        return followHabitEntity.map(this::transformEntity).orElse(null);
    }

    public FollowHabit create(FollowHabitManipulationRequest request) {
        var category = Category.valueOf(request.getCategory());
        var superhabit = habitRepository.findById(request.getSuperhabitId()).orElseThrow();
        var followHabitEntity = new FollowHabitEntity(request.getTitle(), request.getDescription(), request.getFinished(), category, superhabit);
        followHabitEntity = followHabitRepository.save(followHabitEntity);
        return transformEntity(followHabitEntity);
    }

    public FollowHabit update(Long id, FollowHabitManipulationRequest request) {
        var followHabitOptional = followHabitRepository.findById(id);
        if (followHabitOptional.isEmpty()) {
            return null;
        }

        var followHabitEntity = followHabitOptional.get();
        followHabitEntity.setTitle(request.getTitle());
        followHabitEntity.setDescription(request.getDescription());
        followHabitEntity.setFinished(request.getFinished());
        followHabitEntity.setCategory(Category.valueOf(request.getCategory()));
        followHabitEntity = followHabitRepository.save(followHabitEntity);

        return this.transformEntity(followHabitEntity);
    }

    private FollowHabit transformEntity(FollowHabitEntity followHabitEntity) {
        var category = followHabitEntity.getCategory() != null ? followHabitEntity.getCategory().name() : Category.UNKNOWN.name();
        return new FollowHabit(
                followHabitEntity.getId(),
                followHabitEntity.getTitle(),
                followHabitEntity.getDescription(),
                category,
                followHabitEntity.getFinished(),
                habitTransformer.transformEntity(followHabitEntity.getSuperhabit()));
    }


}