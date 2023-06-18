package com.janicolas.CollectorServer.repository;

import com.janicolas.CollectorServer.entity.CommunityEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityEventRepository extends JpaRepository<CommunityEvent, Long> {}
