package com.efundzz.verificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericApiResponse<T> {

    private String message;
    private int status;
    private T data;
}
