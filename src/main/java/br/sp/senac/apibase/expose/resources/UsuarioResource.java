package br.sp.senac.apibase.expose.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;

@Api(value = "Usuario")
@Path("/usuarios")
public class UsuarioResource {

	@GET
	@ApiResponse(responseContainer = "list", code = 200, message = "")
	public String teste() {
		return "teste";
	}

	@GET
	@Path("/{id}")
	@ApiResponse(responseContainer = "list", code = 200, message = "")
	public Object buscarPorId(@PathParam("id") Long id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://www.mocky.io/v2/5a4f9e482f00005b0e790c57");
		
		return target.request().get().readEntity(String.class);
	}
}
