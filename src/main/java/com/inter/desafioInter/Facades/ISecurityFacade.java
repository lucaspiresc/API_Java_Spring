package com.inter.desafioInter.Facades;

import com.inter.desafioInter.dto.UserDTO;

public interface ISecurityFacade {

    UserDTO encryptUserData(com.inter.desafioInter.dto.UserDTO userDto) throws Exception;

    String encrypt(String plainText) throws Exception;

    void generatePublicKey(String encodedPublicKey) throws Exception;
}
