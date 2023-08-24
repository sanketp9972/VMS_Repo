package com.app.dto;

import com.app.entity.UserRoles;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersPostDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String password;
    private UserRoles userRoles;
}
