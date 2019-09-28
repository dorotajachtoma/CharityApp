package pl.coderslab.charity.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5,max = 20)
    private String firstName;

    @NotBlank
    @Size(min = 5,max = 20)
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;


}
