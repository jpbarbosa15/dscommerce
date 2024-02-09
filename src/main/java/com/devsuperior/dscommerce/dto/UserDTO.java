package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.User;
import jakarta.persistence.Column;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private List<String> roles = new ArrayList<>();

    public UserDTO(){};

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getUsername();
        phone = user.getPhone();
        birthDate = user.getBirthDate();
        for(GrantedAuthority role : user.getRoles()){
            roles.add(role.getAuthority());
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<String> getRoles() {
        return roles;
    }
}
