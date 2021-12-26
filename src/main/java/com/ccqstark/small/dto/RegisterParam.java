package com.ccqstark.small.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterParam {

    @NotBlank
    private String role;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String re_password;

}
