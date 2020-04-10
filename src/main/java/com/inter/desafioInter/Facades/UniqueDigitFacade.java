package com.inter.desafioInter.Facades;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import com.inter.desafioInter.Entities.UniqueDigit;
import com.inter.desafioInter.dto.UniqueDigitDTO;
import com.inter.desafioInter.Repositories.UniqueDigitRepository;
import com.inter.desafioInter.Repositories.UserRepository;
import com.inter.desafioInter.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

public class UniqueDigitFacade {

    @Autowired
    private UniqueDigitRepository uniqueDigitRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UniqueDigitDTO> getUniqueDigitsByUserId(Long userId){
        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()){
            List<UniqueDigitDTO> uniqueDigitsDto = user.get()
                    .getUniqueDigits()
                    .stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
            return uniqueDigitsDto;
        }
        else{
            return new ArrayList<UniqueDigitDTO>();
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

    private Long addNumbers(Long value){
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
        UniqueDigitDTO uniqueDigitDTO = modelMapper.map(uniqueDigit, UniqueDigitDTO.class);
        return uniqueDigitDTO;
    }

    private UniqueDigit convertToEntity(UniqueDigitDTO uniqueDigitDTO){
        UniqueDigit uniqueDigit = modelMapper.map(uniqueDigitDTO, UniqueDigit.class);
        return uniqueDigit;
    }
}
