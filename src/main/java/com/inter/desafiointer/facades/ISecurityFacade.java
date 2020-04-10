package com.inter.desafiointer.facades;

import com.inter.desafiointer.dto.UserDTO;

public interface ISecurityFacade {

    UserDTO encryptUserData(com.inter.desafiointer.dto.UserDTO userDto) throws Exception;

    String encrypt(String plainText) throws Exception;

    void generatePublicKey(String encodedPublicKey) throws Exception;
}
