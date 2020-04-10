package com.inter.desafiointer;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import com.inter.desafiointer.facades.UniqueDigitFacade;
import com.inter.desafiointer.entities.UniqueDigit;
import com.inter.desafiointer.dto.UniqueDigitDTO;
import com.inter.desafiointer.entities.User;
import com.inter.desafiointer.repositories.UserRepository;
import com.inter.desafiointer.memorycache.UniqueDigitMemoryCache;
import com.inter.desafiointer.repositories.UniqueDigitRepository;

import static org.mockito.Mockito.when;

import org.modelmapper.ModelMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UniqueDigitFacadeTest {

    @InjectMocks
    private UniqueDigitFacade uniqueDigitFacade;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UniqueDigitRepository uniqueDigitRepository;

    @Mock
    private UniqueDigitMemoryCache uniqueDigitMemoryCache;

    @Mock
    private ModelMapper modelMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUniqueDigitsByUserIdTest(){

        User user = new User();
        user.setUserId(1L);
        user.setUsername("Lucas Teste");
        user.setEmail("email@teste.com");

        UniqueDigitDTO digitDto = new UniqueDigitDTO();
        digitDto.setUserId(1L);
        digitDto.setNumberValue(1L);
        digitDto.setMultiplier(1L);
        digitDto.setDigitValue(1L);

        UniqueDigit digit = new UniqueDigit();
        digit.setUser(user);
        digit.setNumberValue(1L);
        digit.setMultiplier(1L);
        digit.setDigitValue(1L);

        List<UniqueDigit> uniqueDigits = new ArrayList<>();
        uniqueDigits.add(digit);

        user.setUniqueDigits(uniqueDigits);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        when(modelMapper.map(digit, UniqueDigitDTO.class)).thenReturn(digitDto);

        List<UniqueDigitDTO> digits = uniqueDigitFacade.getUniqueDigitsByUserId(1L);
        Assert.assertTrue(!digits.isEmpty());

        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        digits = uniqueDigitFacade.getUniqueDigitsByUserId(2L);
        Assert.assertTrue(digits.isEmpty());
    }

    @Test
    public void calculateUniqueDigitTest(){

        User user = new User();
        user.setUserId(1L);
        user.setUsername("Lucas Teste");
        user.setEmail("email@teste.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Long digit = uniqueDigitFacade.calculateUniqueDigit(3L, 1133L, 1L);
        Assert.assertTrue(digit == 24);
    }

}
