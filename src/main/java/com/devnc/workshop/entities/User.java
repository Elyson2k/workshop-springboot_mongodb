package com.devnc.workshop.entities;

import lombok.*;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {

    private String id;
    private String name;
    private String email;



}
