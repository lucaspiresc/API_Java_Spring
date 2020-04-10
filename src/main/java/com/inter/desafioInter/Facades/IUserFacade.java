package com.inter.desafioInter.Facades;

import com.inter.desafioInter.dto.UserDTO;
import java.util.List;

public interface IUserFacade {

    List<UserDTO> listAllUsers();

    UserDTO getUserById(Long userId);

    UserDTO insertNewUser(UserDTO userDto) throws Exception;

    UserDTO deleteUser(Long userId);

    UserDTO updateUser(UserDTO userDto, Long userId);

}
