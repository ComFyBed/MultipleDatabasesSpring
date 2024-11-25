package com.project.DataAccessingProject.mysql.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "data_Mysql"
)
public class MysqlEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String firstname;
    private String lastname;
}
