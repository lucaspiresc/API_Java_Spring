package com.inter.desafiointer.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.inter.desafiointer.facades.UniqueDigitFacade;
import com.inter.desafiointer.facades.IUniqueDigitFacade;
import com.inter.desafiointer.facades.UserFacade;
import com.inter.desafiointer.facades.IUserFacade;
import com.inter.desafiointer.facades.SecurityFacade;
import com.inter.desafiointer.facades.ISecurityFacade;

@Configuration
public class FacadesConfiguration {

    @Bean
    public IUniqueDigitFacade uniqueDigitFacade(){
        return new UniqueDigitFacade();
    }

    @Bean
    public IUserFacade userFacade(){
        return new UserFacade();
    }

    @Bean
    public ISecurityFacade securityFacade(){
        return new SecurityFacade();
    }

}
