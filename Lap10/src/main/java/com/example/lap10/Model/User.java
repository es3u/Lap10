package com.example.lap10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name can not be Empty")
    @Column(unique = true, columnDefinition = "varchar(15) not null")
    @Min(4)
    @Max(15)
    private String name ;
    @NotEmpty(message = "email can not be empty")
    @Email
    @Column(unique = true, columnDefinition = "varchar(20) not null")
    @Max(20)
    private String email ;
    @NotEmpty(message = "password can not be Empty")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, one special character, and be at least 8 characters long.")
    @Column(columnDefinition = "varchar(8) not null")
    @Max(8)
    private String password;

    @NotNull(message = "age can not be null")
    @Positive
    @Min(21)
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "role can not be empty")
    @Column(columnDefinition = "varchar(10) not null")
    @Check(constraints = "role = 'JOB_SEEKER' OR role ='EMPLOYER'")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$" , message = "Enter JOB_SEEKER OR EMPLOYER")
    private String role ;
}
