package com.inter.desafioInter.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserDTO {

    private Long userId;
    private String name;
    private String email;
    private List<UniqueDigitDTO> uniqueDigits;

    public UserDTO(){
    }
}
