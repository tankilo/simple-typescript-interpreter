package com.tankilo.typescript.interpreter.web;

import com.tankilo.typescript.interpreter.ast.generator.AstService;
import com.tankilo.typescript.interpreter.ast.generator.GraaljsAstService;
import com.tankilo.typescript.interpreter.core.service.DSLService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tankilo E-mail: tankilo@126.com
 */
@Configuration
public class InterpreterConfig {

    @Bean
    public AstService astService() throws Exception {
        AstService astService = new GraaljsAstService();
        astService.init();
        return astService;
    }

    @Bean
    public DSLService dslService() {
        return new DSLService();
    }
}
