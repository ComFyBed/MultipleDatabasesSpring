package com.project.DataAccessingProject.mysql.repository;


import com.project.DataAccessingProject.mysql.model.MysqlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MysqlRepository extends JpaRepository<MysqlEntity, Integer> {

}
