package com.example.appstarter.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private String email;
    @NotBlank(message = "Wpisz hasło")
    private String password;
    @NotBlank(message = "Wybierz rolę")
    private String role;
    @NotBlank(message = "Wpisz imię i nazwisko")
    private String name;
}
