package com.inter.desafiointer.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserDTO {

    private Long userId;
    private String username;
    private String email;
    private List<UniqueDigitDTO> uniqueDigits;

    public UserDTO(){
        //Empty constructor required for Model Mapper
    }
}
