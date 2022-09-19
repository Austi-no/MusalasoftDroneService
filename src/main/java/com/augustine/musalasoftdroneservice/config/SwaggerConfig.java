package com.augustine.musalasoftdroneservice.config;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import org.springframework.context.annotation.*;

/**
 * @author BENARD AUGUSTINE ADAKOLE
 * @created on 19/Sep/2022 - 12:02 PM
 * @project MusalaSoftDroneService
 */

@OpenAPIDefinition(
        info = @Info(
                title = "Musala Soft Drone Service",
                version = "1.0",
                description = "Musala Soft Drone Service API"
        )
)
@Configuration
public class SwaggerConfig {
}
