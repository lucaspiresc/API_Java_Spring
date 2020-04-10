package com.inter.desafiointer.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.inter.desafiointer.facades.UniqueDigitFacade;

@Configuration
public class FacadesConfiguration {

    @Bean
    public com.inter.desafiointer.facades.IUniqueDigitFacade uniqueDigitFacade(){
        return new UniqueDigitFacade();
    }

    @Bean
    public com.inter.desafiointer.facades.IUserFacade userFacade(){
        return new com.inter.desafiointer.facades.UserFacade();
    }

    @Bean
    public com.inter.desafiointer.facades.ISecurityFacade securityFacade(){
        return new com.inter.desafiointer.facades.SecurityFacade();
    }

}
