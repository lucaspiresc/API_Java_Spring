package com.inter.desafiointer.facades;

import com.inter.desafiointer.dto.UserDTO;

public interface ISecurityFacade {

    UserDTO encryptUserData(com.inter.desafiointer.dto.UserDTO userDto);

    String encrypt(String plainText);

    void generatePublicKey(String encodedPublicKey);
}
