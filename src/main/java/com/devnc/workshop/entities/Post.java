package com.devnc.workshop.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "post")
public class Post implements Serializable {

    private String id;
    private Date date;
    private String title;
    private String body;
    private User author;

}