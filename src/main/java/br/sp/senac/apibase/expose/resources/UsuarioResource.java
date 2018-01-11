package br.sp.senac.apibase.expose.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.swagger.oas.annotations.Operation;

@Path("/usuarios")
public class UsuarioResource {

	@GET
	@Operation(summary = "Lista usuários", description = "lista todos os usuários cadastrados")
	public String teste() {
		return "teste";
	}
}
