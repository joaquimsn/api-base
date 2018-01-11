package br.sp.senac.apibase.main.handlers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.sp.senac.apibase.main.exceptions.ExposeBusinessException;
import br.sp.senac.apibase.main.exceptions.MessageResponseError;

@Provider
public class ExposeBusinessExceptionMapper implements ExceptionMapper<ExposeBusinessException>{
	private static Logger logger = LogManager.getLogger(ExposeBusinessExceptionMapper.class);

	@Override
	public Response toResponse(ExposeBusinessException exception) {
		logger.warn(exception.getSystemCode() + ": " + exception.getMessage(), exception.getCause());

		MessageResponseError message = MessageResponseError.of(exception.getSystemCode(), exception.getHttpStatusCode(), exception.getMessage());
		return Response.status(exception.getHttpStatusCode()).type(MediaType.APPLICATION_JSON).entity(message).build();
	}
}
