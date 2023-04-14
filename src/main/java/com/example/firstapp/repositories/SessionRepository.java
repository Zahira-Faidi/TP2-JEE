package com.example.firstapp.repositories;

import com.example.firstapp.Entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Integer> {
}
