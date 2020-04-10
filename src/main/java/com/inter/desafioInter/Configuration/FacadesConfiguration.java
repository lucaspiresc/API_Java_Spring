package com.inter.desafioInter.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.inter.desafioInter.Facades.UniqueDigitFacade;

@Configuration
public class FacadesConfiguration {

    @Bean
    public UniqueDigitFacade uniqueDigitFacade(){
        return new UniqueDigitFacade();
    }

}
