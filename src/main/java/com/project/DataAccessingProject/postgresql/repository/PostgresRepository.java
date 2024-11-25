package com.project.DataAccessingProject.postgresql.repository;

import com.project.DataAccessingProject.postgresql.model.PostgresSqlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresRepository extends JpaRepository<PostgresSqlEntity, Integer> {
}
