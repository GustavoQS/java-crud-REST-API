package com.saraiva.crud.infra;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponseDTO {
    String response;

    public ExceptionResponseDTO(String response) {
        this.response = response;
    }

}
