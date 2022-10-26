package com.devnc.workshop.dto;

import com.devnc.workshop.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class AuthorDTO {

    private String id;
    private String name;

    public AuthorDTO(User user){
        id = user.getId();
        name = user.getName();
    }

}
