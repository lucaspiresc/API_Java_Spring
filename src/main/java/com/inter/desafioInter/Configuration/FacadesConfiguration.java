package com.inter.desafioInter.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.inter.desafioInter.Facades.UniqueDigitFacade;
import com.inter.desafioInter.Facades.IUniqueDigitFacade;
import com.inter.desafioInter.Facades.UserFacade;
import com.inter.desafioInter.Facades.IUserFacade;
import com.inter.desafioInter.Facades.SecurityFacade;
import com.inter.desafioInter.Facades.ISecurityFacade;

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
