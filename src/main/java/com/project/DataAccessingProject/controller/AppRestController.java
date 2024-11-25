package com.project.DataAccessingProject.controller;


import com.project.DataAccessingProject.mysql.dto.MysqlEntityDto;
import com.project.DataAccessingProject.postgresql.dto.PostgresEntityDto;
import com.project.DataAccessingProject.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AppRestController {

    private final AppService service;

    @PostMapping("/mysql/post")
    public ResponseEntity<String> postEntityMysql(
            @RequestBody MysqlEntityDto mysqlEntityDto
            ){
        return service.saveEntityMsql(mysqlEntityDto);
    }

    @PostMapping("/postgres/post")
    public ResponseEntity<String> postEntityPostgres(
            @RequestBody PostgresEntityDto postgresEntityDto
    ){
        return service.saveEntityPostgres(postgresEntityDto);
    }

    @DeleteMapping("/mysql/delete/{id}")
    public ResponseEntity<String> deleteEntityMysql(
            @PathVariable("id") Integer id
    ){
        return service.deleteEntityMysql(id);
    }

    @DeleteMapping("/postgres/delete/{id}")
    public ResponseEntity<String> deleteEntityPostgres(
            @PathVariable("id") Integer id
    ){
        return service.deleteEntityPostgres(id);
    }
}
