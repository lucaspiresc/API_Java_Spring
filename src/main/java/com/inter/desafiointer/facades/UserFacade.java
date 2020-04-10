package com.inter.desafiointer.facades;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.inter.desafiointer.repositories.UserRepository;
import com.inter.desafiointer.repositories.UniqueDigitRepository;
import com.inter.desafiointer.dto.UserDTO;
import com.inter.desafiointer.entities.User;
import com.inter.desafiointer.entities.UniqueDigit;

public class UserFacade implements IUserFacade{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UniqueDigitRepository uniqueDigitRepository;

    @Autowired
    private ISecurityFacade securityFacade;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> listAllUsers(){
        return userRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(java.util.stream.Collectors.toList());
    }

    public UserDTO getUserById(Long userId){
        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()){
            return convertToDto(user.get());
        }
        else {
            return null;
        }
    }

    public UserDTO insertNewUser(UserDTO userDto) {
        try {
            userDto = securityFacade.encryptUserData(userDto);
            User user = convertToEntity(userDto);

            List<UniqueDigit> uniqueDigits = user.getUniqueDigits();
            user.setUniqueDigits(null);

            User savedUser = userRepository.save(user);

            uniqueDigits.forEach(x -> x.setUser(user));
            List<UniqueDigit> savedDigits = uniqueDigitRepository.saveAll(uniqueDigits);

            savedUser.setUniqueDigits(savedDigits);

            return convertToDto(savedUser);
        }
        catch (Exception ex) {
            return null;
        }
    }

    public UserDTO deleteUser(Long userId){
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            User userToDelete = user.get();
            userRepository.delete(userToDelete);

            return convertToDto(userToDelete);
        }
        else {
            return null;
        }
    }

    public UserDTO updateUser(UserDTO userDto, Long userId){
        try {
            Optional<User> user = userRepository.findById(userId);

            if (user.isPresent()) {
                User userToUpdate = user.get();
                userDto = securityFacade.encryptUserData(userDto);

                userToUpdate.setUsername(userDto.getUsername());
                userToUpdate.setEmail(userDto.getEmail());

                User updatedUser = userRepository.save(userToUpdate);

                return convertToDto(updatedUser);
            } else {
                return null;
            }
        }
        catch (Exception ex){
            return null;
        }
    }

    private UserDTO convertToDto(User user){
        return modelMapper.map(user, UserDTO.class);
    }

    private User convertToEntity(UserDTO userDto){
        return modelMapper.map(userDto, User.class);
    }

}
