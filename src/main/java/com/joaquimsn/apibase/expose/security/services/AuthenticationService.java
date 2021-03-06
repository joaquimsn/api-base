package com.joaquimsn.apibase.expose.security.services;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.joaquimsn.apibase.expose.security.Credential;
import com.joaquimsn.apibase.main.Ambiente;

public class AuthenticationService {

	public Credential verify(String token) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(Ambiente.getUrlAutorizacao());
		Response response = target.request().get();
		
		if (response.getStatus() == Status.OK.getStatusCode()) {
			Credential credential = response.readEntity(Credential.class);
			response.close();
			return credential;
		}
		
		String responseAuthError = response.readEntity(String.class);
		response.close();
		
		throw new ForbiddenException(Response.status(response.getStatus()).type(MediaType.APPLICATION_JSON).entity(responseAuthError).build());
	}
}
