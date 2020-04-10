package com.inter.desafiointer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.inter.desafiointer.memorycache.UniqueDigitMemoryCache;
import org.modelmapper.ModelMapper;

@Configuration
public class SpringConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public UniqueDigitMemoryCache uniqueDigitMemoryCache(){
        return new UniqueDigitMemoryCache();
    }

}
