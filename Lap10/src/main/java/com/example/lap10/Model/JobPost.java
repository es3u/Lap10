package com.example.lap10.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @NotEmpty(message = "title can not be empty")
    @Column(unique = true, columnDefinition = "varchar(20) not null")
    @Min(4)
    @Max(20)
    private String title ;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(columnDefinition = "datetime ")
    private Date postingDate ;
}
