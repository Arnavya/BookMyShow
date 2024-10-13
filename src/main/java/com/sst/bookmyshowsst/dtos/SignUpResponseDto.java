package com.sst.bookmyshowsst.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDto {
    private Long id;
    private String email;
    private ResponseStatus responseStatus;
}
