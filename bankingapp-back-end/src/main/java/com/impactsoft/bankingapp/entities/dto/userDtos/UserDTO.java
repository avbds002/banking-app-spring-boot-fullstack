package com.impactsoft.bankingapp.entities.dto.userDtos;

import com.impactsoft.bankingapp.entities.User;

public class UserDTO {
    private Long id;
    private String cpf;
    private String email;
    private String password;

    public UserDTO() {}

    public UserDTO(Long id, String cpf, String email, String password) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public UserDTO(User entity) {
        id = entity.getId();
        cpf = entity.getCpf();
        email = entity.getEmail();
        password = entity.getPassword();
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
