package com.ducami.intro.domain.code.repository;

import com.ducami.intro.domain.code.entity.CodeExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CodeExampleRepository extends JpaRepository<CodeExample, Long> {

    @Query(value = "SELECT * FROM code_example ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<CodeExample> findRandomCode();
}