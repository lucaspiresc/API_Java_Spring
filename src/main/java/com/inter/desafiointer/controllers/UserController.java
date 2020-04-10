package com.inter.desafiointer.controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
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
import org.springframework.http.HttpStatus;
import com.inter.desafiointer.facades.IUserFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.inter.desafiointer.dto.UserDTO;
import java.util.List;

@RestController
@RequestMapping(value="api/users")
@Api(value = "Controller de Usuarios")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserFacade userFacade;

    @GetMapping("/all")
    @ApiOperation(value = "Recupera todos os usuarios")
    public ResponseEntity<List<UserDTO>> listUsers(){
        try {
            List<UserDTO> usersDto = userFacade.listAllUsers();
            return ResponseEntity.ok(usersDto);
        }
        catch (Exception ex){
            logger.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("user/{id}")
    @ApiOperation(value = "Recupera usuario com base no Id")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        try {
            UserDTO userDto = userFacade.getUserById(id);

            if (userDto != null) {
                return ResponseEntity.ok(userDto);
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
        catch (Exception ex){
            logger.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/new")
    @ApiOperation(value = "Cadastra um novo usuario")
    public ResponseEntity<UserDTO> insertNewUser(@RequestBody UserDTO userDto){
        try {
            UserDTO savedUser = userFacade.insertNewUser(userDto);
            if(savedUser != null){
                return ResponseEntity.ok(savedUser);
            }
            else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
        catch (Exception ex){
            logger.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deleta um usuario")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id){
        try {
            UserDTO deletedUser = userFacade.deleteUser(id);

            if (deletedUser != null) {
                return ResponseEntity.ok(deletedUser);
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
        catch (Exception ex){
            logger.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("update/{id}")
    @ApiOperation(value = "Atualiza cadastro de um usuario")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto, @PathVariable Long id){
        try {
            UserDTO updatedUser = userFacade.updateUser(userDto, id);

            if(updatedUser != null){
                return ResponseEntity.ok(updatedUser);
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
        catch (Exception ex){
            logger.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
