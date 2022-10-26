package com.devnc.workshop.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "user")
public class User implements Serializable {

    private String id;
    private String name;
    private String email;



}
