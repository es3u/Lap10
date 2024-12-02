package com.example.lap10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @NotNull(message = "user id can not be empty")
    @Column(unique = true, columnDefinition = "int not null")
    private Integer userId ;

    @NotNull(message = "job post id can not be empty")
    @Column(unique = true, columnDefinition = "int not null")

    private Integer jobPostId ;
}
