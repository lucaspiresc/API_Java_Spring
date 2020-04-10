package com.inter.desafiointer.facades;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import com.inter.desafiointer.entities.UniqueDigit;
import com.inter.desafiointer.dto.UniqueDigitDTO;
import com.inter.desafiointer.repositories.UniqueDigitRepository;
import com.inter.desafiointer.repositories.UserRepository;
import com.inter.desafiointer.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

public class UniqueDigitFacade implements IUniqueDigitFacade{

    @Autowired
    private UniqueDigitRepository uniqueDigitRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UniqueDigitDTO> getUniqueDigitsByUserId(Long userId){
        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()){
            return user.get()
                    .getUniqueDigits()
                    .stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        }
        else{
            return new ArrayList<>();
        }
    }

    public Long calculateUniqueDigit(Long value, Long multiplier, Long userId){
        Long sum = addNumbers(value) * multiplier;
        Long uniqueDigit = addNumbers(sum);

        if(userId != null){
            insertDigit(value,multiplier,uniqueDigit,userId);
        }

        return uniqueDigit;
    }

    public Long addNumbers(Long value){
        Long sum = 0L;
        while(value > 0) {
            sum += (value % 10);
            value /= 10;
        }
        return sum;
    }

    public void insertDigit(Long value, Long multiplier, Long result, Long userId){
        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()){
            UniqueDigit uniqueDigit = new UniqueDigit();

            uniqueDigit.setNumberValue(value);
            uniqueDigit.setMultiplier(multiplier);
            uniqueDigit.setDigitValue(result);
            uniqueDigit.setUser(user.get());

            uniqueDigitRepository.save(uniqueDigit);
        }
    }

    private UniqueDigitDTO convertToDto(UniqueDigit uniqueDigit){
        return modelMapper.map(uniqueDigit, UniqueDigitDTO.class);
    }
}
