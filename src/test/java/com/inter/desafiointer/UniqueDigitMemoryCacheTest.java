package com.inter.desafiointer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.inter.desafiointer.entities.UniqueDigit;
import com.inter.desafiointer.memorycache.UniqueDigitMemoryCache;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UniqueDigitMemoryCacheTest {

    @InjectMocks
    private UniqueDigitMemoryCache uniqueDigitMemoryCache;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void putTest(){
        UniqueDigit digit = new UniqueDigit();
        digit.setNumberValue(1L);
        digit.setMultiplier(1L);
        digit.setNumberValue(1L);
        digit.setDigitValue(1L);

        for(Long i = 0L; i < 12; i++){
            digit.setDigitId(i);
            uniqueDigitMemoryCache.put(digit);
        }

        Assert.assertTrue(uniqueDigitMemoryCache.getCache().size() == 10);
    }

}
