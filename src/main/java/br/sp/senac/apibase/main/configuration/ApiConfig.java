package br.sp.senac.apibase.main.configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.sp.senac.apibase.main.SenacUriConventions;

@ApplicationPath(SenacUriConventions.BASE_URL_API)
public class ApiConfig extends Application {
	
	@PostConstruct
	private void init() {
		new SwaggerConfig();
	}
}
