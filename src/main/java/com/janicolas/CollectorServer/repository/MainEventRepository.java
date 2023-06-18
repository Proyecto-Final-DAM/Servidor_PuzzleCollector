package com.janicolas.CollectorServer.repository;

import com.janicolas.CollectorServer.entity.MainEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainEventRepository extends JpaRepository<MainEvent, Long> {}
