package com.inter.desafioInter.Facades;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.inter.desafioInter.Repositories.UserRepository;
import com.inter.desafioInter.Repositories.UniqueDigitRepository;
import com.inter.desafioInter.dto.UserDTO;
import com.inter.desafioInter.Entities.User;
import com.inter.desafioInter.Entities.UniqueDigit;

public class UserFacade {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UniqueDigitRepository uniqueDigitRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> listAllUsers(){
        List<UserDTO> usersDto = userRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(java.util.stream.Collectors.toList());

        return usersDto;
    }

    public UserDTO getUserById(Long userId){
        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()){
            UserDTO userDto = convertToDto(user.get());
            return userDto;
        }
        else {
            return null;
        }
    }

    public UserDTO insertNewUser(UserDTO userDto){
        User user = convertToEntity(userDto);

        List<UniqueDigit> uniqueDigits = user.getUniqueDigits();
        user.setUniqueDigits(null);

        User savedUser = userRepository.save(user);

        uniqueDigits.stream().forEach(x -> x.setUser(user));
        List<UniqueDigit> savedDigits = uniqueDigitRepository.saveAll(uniqueDigits);

        savedUser.setUniqueDigits(savedDigits);

        UserDTO savedUserDto = convertToDto(savedUser);

        return savedUserDto;
    }

    public UserDTO deleteUser(Long userId){
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            User userToDelete = user.get();
            userRepository.delete(userToDelete);

            UserDTO deletedUser = convertToDto(userToDelete);
            return deletedUser;
        }
        else {
            return null;
        }
    }

    public UserDTO updateUser(UserDTO userDto, Long userId){
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            User userToUpdate = user.get();

            userToUpdate.setUsername(userDto.getUsername());
            userToUpdate.setEmail(userDto.getEmail());

            User updatedUser = userRepository.save(userToUpdate);

            UserDTO updatedUserDto = convertToDto(updatedUser);
            return updatedUserDto;
        }
        else {
            return null;
        }
    }

    private UserDTO convertToDto(User user){
        UserDTO userDto = modelMapper.map(user, UserDTO.class);
        return userDto;
    }

    private User convertToEntity(UserDTO userDto){
        User user = modelMapper.map(userDto, User.class);
        return user;
    }

}
