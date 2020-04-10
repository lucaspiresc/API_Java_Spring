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
import com.inter.desafioInter.Facades.UniqueDigitFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import com.inter.desafioInter.dto.UserDTO;
import com.inter.desafioInter.dto.UniqueDigitDTO;
import com.inter.desafioInter.Entities.UniqueDigit;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping(value="api/digits")
@Api(value = "Controller de Digitos Unicos")
public class UniqueDigitController {

    @Autowired
    private UniqueDigitFacade uniqueDigitFacade;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/calculate")
    @ApiOperation(value = "Calcula um digito unico com base nos parametros")
    public ResponseEntity<?> calculateDigit(@RequestBody UniqueDigitDTO uniqueDigitDto){
        try {
            Long digit = uniqueDigitFacade.calculateUniqueDigit(uniqueDigitDto.getNumberValue(), uniqueDigitDto.getMultiplier());
            uniqueDigitDto.setDigitValue(digit);

            if(uniqueDigitDto.getUserId() != null){
                UniqueDigit uniqueDigit = convertToEntity(uniqueDigitDto);
                return ResponseEntity.ok("Insere: " + digit);
            }
            else{
                return ResponseEntity.ok("Não insere: " + digit);
            }
        }
        catch (Exception ex){
            //log error ?
            return ResponseEntity.badRequest().build();
        }
    }

    private UniqueDigitDTO convertToDto(UniqueDigit uniqueDigit){
        UniqueDigitDTO uniqueDigitDTO = modelMapper.map(uniqueDigit, UniqueDigitDTO.class);
        return uniqueDigitDTO;
    }

    private UniqueDigit convertToEntity(UniqueDigitDTO uniqueDigitDTO){
        UniqueDigit uniqueDigit = modelMapper.map(uniqueDigitDTO, UniqueDigit.class);
        return uniqueDigit;
    }

}
