package com.janicolas.CollectorServer.repository;

import com.janicolas.CollectorServer.entity.Collection;
import com.janicolas.CollectorServer.entity.CollectionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CollectionRepository extends JpaRepository<Collection, CollectionId> {
    List<Collection> findByUserId(Long id);

    Optional<Collection> findByUserIdAndPuzzleId(Long user_id, Long puzzle_id);
    Boolean existsByPuzzleIdAndUserId(Long puzzle_id, Long user_id);
}
