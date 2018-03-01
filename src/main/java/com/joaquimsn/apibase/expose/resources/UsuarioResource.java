package com.joaquimsn.apibase.expose.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.joaquimsn.apibase.main.exceptions.MessageResponseError;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.ApiKeyAuthDefinition.ApiKeyLocation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SecurityDefinition;
import io.swagger.annotations.SwaggerDefinition;

@Path("/usuarios")
@Api(value = "Usuario")
@SwaggerDefinition(securityDefinition = @SecurityDefinition(apiKeyAuthDefinitions = {
		@ApiKeyAuthDefinition(in = ApiKeyLocation.HEADER, key = "jwt", name = "authorization", description = "Necesário informar token para autorização seguindo o padrão jwt {token}")
}))
@ApiResponses({
		@ApiResponse(code = 401, message = "Não autenticado", response = MessageResponseError.class),
		@ApiResponse(code = 403, message = "Não autorizado", response = MessageResponseError.class),
		@ApiResponse(code = 500, message = "Erro interno", response = MessageResponseError.class)
})
public class UsuarioResource {

	@GET
	@ApiOperation(value = "Retorna todos os usuários cadastrados", response = Object[].class)
	public Object teste() {
		return "teste";
	}

	@GET
	@Path("/{id}")
	@ApiOperation(value = "Retorna o usuário correspondente ao id informado", response = Object.class)
	public Object buscarPorId(@ApiParam(value = "Id do usuário já cadastrado") @PathParam("id") Long id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://www.mocky.io/v2/5a4f9e482f00005b0e790c57");
		
		return target.request().get().readEntity(String.class);
	}
}
