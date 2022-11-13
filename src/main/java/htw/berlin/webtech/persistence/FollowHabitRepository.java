package htw.berlin.webtech.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowHabitRepository extends JpaRepository<FollowHabitEntity, Long> {
}
