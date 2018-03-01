package com.joaquimsn.apibase.main.configuration;

import com.joaquimsn.apibase.main.Ambiente;
import com.joaquimsn.apibase.main.SenacUriConventions;

import io.swagger.jaxrs.config.BeanConfig;

/**
 * @author Joaquim Neto
 * Github joaquimsn
 */
public class SwaggerConfig {

	public SwaggerConfig() {
		inicializar();
	}

	public void inicializar() {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setTitle("Senac API");
		beanConfig.setVersion("1.0.0");
		beanConfig.setHost(Ambiente.getPublicHost());
		beanConfig.setBasePath("/apibase" + SenacUriConventions.BASE_URL_API);
		beanConfig.setResourcePackage("com.joaquimsn.apibase.expose.resources");
		beanConfig.setScan(true);
	}
}
