package com.project.DataAccessingProject.postgresql.model;

import jakarta.persistence.*;
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
        name = "data_Postgres"
)
public class PostgresSqlEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String firstname;
    private String lastname;
}
