package de.oryfox.vinylish.tags;

import de.oryfox.vinylish.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findAllByCreator(User creator);
    Optional<Tag> findByCreatorAndId(User creator, Long id);
}
