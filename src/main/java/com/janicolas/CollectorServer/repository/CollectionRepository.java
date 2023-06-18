package com.janicolas.CollectorServer.repository;

import com.janicolas.CollectorServer.entity.Collection;
import com.janicolas.CollectorServer.entity.CollectionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionRepository extends JpaRepository<Collection, CollectionId> {
    List<Collection> findByUserId(Long id);
    Boolean existsByPuzzleIdAndUserId(Long puzzle_id, Long user_id);
}
