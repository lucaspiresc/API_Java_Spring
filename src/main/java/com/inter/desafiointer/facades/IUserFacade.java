package com.inter.desafiointer.facades;

import com.inter.desafiointer.dto.UserDTO;
import java.util.List;

public interface IUserFacade {

    List<UserDTO> listAllUsers();

    UserDTO getUserById(Long userId);

    UserDTO insertNewUser(UserDTO userDto);

    UserDTO deleteUser(Long userId);

    UserDTO updateUser(UserDTO userDto, Long userId);

}
