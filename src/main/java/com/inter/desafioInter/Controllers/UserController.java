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
import com.inter.desafioInter.Facades.IUserFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.inter.desafioInter.dto.UserDTO;
import java.util.List;

@RestController
@RequestMapping(value="api/users")
@Api(value = "Controller de Usuarios")
public class UserController {

    @Autowired
    private IUserFacade userFacade;

    @GetMapping("/all")
    @ApiOperation(value = "Recupera todos os usuarios")
    public ResponseEntity<?> listUsers(){
        try {
            List<UserDTO> usersDto = userFacade.listAllUsers();

            if (usersDto != null && usersDto.size() > 0) {
                return ResponseEntity.ok(usersDto);
            }
            else {
                return ResponseEntity.badRequest().body("Unable to find any users");
            }
        }
        catch (Exception ex){
            //log error ?
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("user/{id}")
    @ApiOperation(value = "Recupera usuario com base no Id")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        try {
            UserDTO userDto = userFacade.getUserById(id);

            if (userDto != null) {
                return ResponseEntity.ok(userDto);
            }
            else {
                return ResponseEntity.badRequest().body("Unable to find user");
            }
        }
        catch (Exception ex){
            //log error ?
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/new")
    @ApiOperation(value = "Cadastra um novo usuario")
    public ResponseEntity<?> insertNewUser(@RequestBody UserDTO userDto){
        try {
            UserDTO savedUser = userFacade.insertNewUser(userDto);
            if(savedUser != null){
                return ResponseEntity.ok(savedUser);
            }
            else{
                return ResponseEntity.badRequest().body("Unable to save new user");
            }
        }
        catch (Exception ex){
            //log error ?
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Deleta um usuario")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        try {
            UserDTO deletedUser = userFacade.deleteUser(id);

            if (deletedUser != null) {
                return ResponseEntity.ok(deletedUser);
            }
            else {
                return ResponseEntity.badRequest().body("Unable to find user to delete");
            }
        }
        catch (Exception ex){
            //log error ?
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("update/{id}")
    @ApiOperation(value = "Atualiza cadastro de um usuario")
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDto, @PathVariable Long id){
        try {
            UserDTO updatedUser = userFacade.updateUser(userDto, id);

            if(updatedUser != null){
                return ResponseEntity.ok(updatedUser);
            }
            else {
                return ResponseEntity.badRequest().body("Unable to update user");
            }
        }
        catch (Exception ex){
            //log error ?
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
