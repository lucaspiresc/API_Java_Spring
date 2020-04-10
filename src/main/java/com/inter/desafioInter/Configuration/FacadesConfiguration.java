package com.inter.desafioInter.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.inter.desafioInter.Facades.UniqueDigitFacade;
import com.inter.desafioInter.Facades.UserFacade;

@Configuration
public class FacadesConfiguration {

    @Bean
    public UniqueDigitFacade uniqueDigitFacade(){
        return new UniqueDigitFacade();
    }

    @Bean
    public UserFacade userFacade(){
        return new UserFacade();
    }

}
