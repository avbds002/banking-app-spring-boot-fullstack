package com.impactsoft.bankingapp.entities.dto.userDtos;

import com.impactsoft.bankingapp.entities.User;

public class UserPasswordDTO {

    private Long id;
    private String currentPassword;
    private String newPassword;
    private String confirmPassword;

    public UserPasswordDTO() {}

    public  UserPasswordDTO(User entity) {
        id = entity.getId();
        currentPassword = entity.getPassword();
    }

    public UserPasswordDTO(Long id, String currentPassword, String newPassword, String confirmPassword) {
        this.id = id;
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public Long getId() {
        return id;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
