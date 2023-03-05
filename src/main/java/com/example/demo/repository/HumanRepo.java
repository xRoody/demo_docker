package com.example.demo.repository;

import com.example.demo.entity.Human;
import jakarta.persistence.NamedEntityGraph;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface HumanRepo extends JpaRepository<Human, UUID> {
    @EntityGraph("Human.friends")
    Optional<Human> findById(UUID uuid);
}
