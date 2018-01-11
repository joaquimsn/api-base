package br.sp.senac.apibase.main.configuration;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.swagger.oas.integration.SwaggerConfiguration;
import io.swagger.oas.models.OpenAPI;
import io.swagger.oas.models.info.Info;

/**
 * @author Joaquim Neto
 * Github joaquimsn
 */
public class SwaggerConfig {

	public SwaggerConfig() {
		inicializar();
	}

	public void inicializar() {
		OpenAPI openAPI = new OpenAPI();
		Info info = new Info()
				.title("Senac API - apibase")
				.description("Projeto para para construção de APIs usando jax-rs");
		
		openAPI.info(info);
		
		SwaggerConfiguration config = new SwaggerConfiguration();
		config.openAPI(openAPI).resourcePackages(Stream.of("br.sp.senac.apibase.expose.resources").collect(Collectors.toSet()));
//		BeanConfig beanConfig = new BeanConfig();
//		beanConfig.setTitle("Senac API - noticia-expose");
//		beanConfig.setVersion("1.0.0");
//		beanConfig.setHost(Ambiente.getPublicHost());
//		beanConfig.setBasePath("/apibase" + SenacUriConventions.BASE_URL_API);
//		beanConfig.setResourcePackage("br.sp.senac.apibase.expose.resources");
//		beanConfig.setScan(true);
	}
}
