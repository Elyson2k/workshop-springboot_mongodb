package com.devnc.workshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO implements Serializable {

    private String text;
    private Date date;
    private AuthorDTO authorDTO;
}
