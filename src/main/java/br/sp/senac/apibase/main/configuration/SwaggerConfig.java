package br.sp.senac.apibase.main.configuration;

import br.sp.senac.apibase.main.Ambiente;
import br.sp.senac.apibase.main.SenacUriConventions;
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
		beanConfig.setResourcePackage("br.sp.senac.apibase.expose.resources");
		beanConfig.setScan(true);
	}
}
