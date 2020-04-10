package com.inter.desafioInter.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import com.inter.desafioInter.Repositories.UserRepository;
import com.inter.desafioInter.Entities.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import com.inter.desafioInter.dto.UserDTO;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping(value="api/users")
@Api(value = "Controller de Usuarios")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/all")
    @ApiOperation(value = "Recupera todos os usuarios")
    public ResponseEntity<?> listUsers(){
        try {
            List<UserDTO> usersDto = userRepository.findAll().stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());

            if (usersDto != null && usersDto.size() > 0) {
                return ResponseEntity.ok(usersDto);
            }
            else {
                return ResponseEntity.badRequest().build();
            }
        }
        catch (Exception ex){
            //log error ?
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("user/{id}")
    @ApiOperation(value = "Recupera usuario com base no Id")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        try {
            Optional<User> user = userRepository.findById(id);

            if (user.isPresent()) {
                UserDTO userDto = convertToDto(user.get());
                return ResponseEntity.ok(userDto);
            }
            else {
                return ResponseEntity.badRequest().build();
            }
        }
        catch (Exception ex){
            //log error ?
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/new")
    @ApiOperation(value = "Cadastra um novo usuario")
    public ResponseEntity<?> newUser(@RequestBody UserDTO userDto){
        try {
            User user = convertToEntity(userDto);
            user = userRepository.save(user);
            return ResponseEntity.ok(convertToDto(user));
        }
        catch (Exception ex){
            //log error ?
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deleta um usuario")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        try {
            Optional<User> user = userRepository.findById(id);

            if (user.isPresent()) {
                User userToDelete = user.get();
                userRepository.delete(userToDelete);
                return ResponseEntity.ok(convertToDto(userToDelete));
            }
            else {
                //log error ?
                return ResponseEntity.badRequest().build();
            }
        }
        catch (Exception ex){
            //log error ?
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("update/")
    @ApiOperation(value = "Atualiza cadastro de um usuario")
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDto){
        try {
            User updatedUser = convertToEntity(userDto);
            updatedUser = userRepository.save(updatedUser);
            return ResponseEntity.ok(convertToDto(updatedUser));
        }
        catch (Exception ex){
            //log error ?
            return ResponseEntity.badRequest().build();
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
