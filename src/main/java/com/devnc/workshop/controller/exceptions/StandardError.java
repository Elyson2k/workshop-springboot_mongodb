package com.devnc.workshop.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {

    private Long timestamp;
    private Integer status;
    private String error;

}
