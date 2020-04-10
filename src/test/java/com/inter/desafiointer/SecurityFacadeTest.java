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
import com.inter.desafiointer.facades.SecurityFacade;
import com.inter.desafiointer.dto.UserDTO;

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
public class SecurityFacadeTest {

    @InjectMocks
    private SecurityFacade securityFacade;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void encryptUserDataTests() throws Exception{

        String key = "MIIBITANBgkqhkiG9w0BAQEFAAOCAQ4AMIIBCQKCAQBdt6qhEo6QatKDUhSHJqa9vOq4QZ+13esh8YiCBzoVai9PwNKPtSVH" +
                "Jvhhvdf5u96V4XH98aMK8nImUdwD6+i3wdRp8xInyWeJMHdolkBZUZ7+ZnJxO6U7Pqiqg864WXhFfG7qMdDHg8mzHpHoWSosT6Zue9" +
                "VD33UlcCSzF8MbGpuMXGIRhSOSn9RjkQuLXdn6BuwbRw4viCcRJ7tQxopWjy5loCrW2wTjzdaf+3XVbThGi6HK0tuDGGdH4LlctNjp" +
                "7Lje1pdGJJvRHDUYGijFXF/Ku1zXBxfCmirrWbU/ZqKp0GEkcAaCG5ZQa3hQ4rYsK4fpI+nRtTyCfdnGH5+jAgMBAAE=";

        UserDTO userDto = new UserDTO();
        userDto.setUserId(1L);
        userDto.setUsername("Lucas Teste");
        userDto.setEmail("email@teste.com");
        userDto.setUniqueDigits(new ArrayList<>());

        securityFacade.generatePublicKey(key);

        userDto = securityFacade.encryptUserData(userDto);
        Assert.assertTrue(userDto != null );
    }

}
