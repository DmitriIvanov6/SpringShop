package ru.gb.validation;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    @NotNull(message = "Не может быть пустым")
    @NotEmpty(message = "Не может быть пустым")
    private String username;
    @NotNull(message = "Не может быть пустым")
    @NotEmpty(message = "Не может быть пустым")
    private String password;
    @NotNull(message = "Не может быть пустым")
    @NotEmpty(message = "Не может быть пустым")
    private String firstname;
    @NotNull(message = "Не может быть пустым")
    @NotEmpty(message = "Не может быть пустым")
    private String lastname;
    @NotNull(message = "Не может быть пустым")
    @NotEmpty(message = "Не может быть пустым")
    private String email;

}
