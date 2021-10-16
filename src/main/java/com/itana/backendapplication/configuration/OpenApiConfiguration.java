package com.itana.backendapplication.configuration;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
/**
* OpenApiConfiguration
*/

@Configuration
public class OpenApiConfiguration {	
	public OpenAPI vehicleOpenApi(){
		return new OpenAPI()
			.components(new Components())
			.info(new Info()
			.title("Annual motor vehicle population API"));

	}
}
