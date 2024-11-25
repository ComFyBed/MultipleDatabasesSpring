package com.project.DataAccessingProject.service;

import com.project.DataAccessingProject.mysql.dto.MysqlEntityDto;
import com.project.DataAccessingProject.mysql.model.MysqlEntity;
import com.project.DataAccessingProject.mysql.repository.MysqlRepository;
import com.project.DataAccessingProject.postgresql.dto.PostgresEntityDto;
import com.project.DataAccessingProject.postgresql.model.PostgresSqlEntity;
import com.project.DataAccessingProject.postgresql.repository.PostgresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppService {

    private final MysqlRepository mysqlRepository;
    private final PostgresRepository postgresRepository;



    public ResponseEntity<String> saveEntityMsql(MysqlEntityDto mysqlEntityDto){
        var entity = MysqlEntity.builder()
                .firstname(mysqlEntityDto.getFirstname())
                .lastname(mysqlEntityDto.getLastname())
                .build();
        mysqlRepository.save(entity);

        return ResponseEntity.ok("Saved in Mysql Database !");
    }

    public ResponseEntity<String> saveEntityPostgres(PostgresEntityDto postgresEntityDto){
        var entity = PostgresSqlEntity.builder()
                .firstname(postgresEntityDto.getFirstname())
                .lastname(postgresEntityDto.getLastname())
                .build();
        postgresRepository.save(entity);
        return ResponseEntity.ok("Saved in Postgresql Database !");
    }


    public ResponseEntity<String> deleteEntityMysql(Integer id){
        var entity = mysqlRepository.findById(id).orElseThrow();
        mysqlRepository.delete(entity);
        return ResponseEntity.ok("Deleted from the Mysql Database !");
    }

    public ResponseEntity<String> deleteEntityPostgres(Integer id){
        var entity = postgresRepository.findById(id).orElseThrow();
        postgresRepository.delete(entity);
        return ResponseEntity.ok("Deleted from the Postgresql Database !");
    }





}
