package br.sp.senac.apibase.expose.security;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;

import br.sp.senac.apibase.expose.security.enums.Rule;
import br.sp.senac.apibase.main.exceptions.enums.TypeExposeBusinessException;

/**
 * @author Joaquim Neto
 * Github joaquimsn
 */
@Interceptor
@SenacAuthorization
public class AuthorizationInteceptor {
	
	@Inject
	private HttpServletRequest request;
	
	@AroundInvoke
	public Object checkAccess(InvocationContext ctx) throws Exception {
		ctx.getClass().getAnnotation(SenacAuthorization.class);
		Optional<SenacAuthorization> annotation = Optional.ofNullable(ctx.getMethod().getAnnotation(SenacAuthorization.class));
		checkAuthorization(annotation);
		
		return ctx.proceed();
	}
	
	private void checkAuthorization(Optional<SenacAuthorization> annotation) {
		if (annotation.isPresent()) {
			Credential credential = (Credential) request.getAttribute("credential");
			List<Rule> rules = Arrays.asList(annotation.get().rules());
			
			br.sp.senac.apibase.expose.security.Rule ruleFound = null;
			for (Rule rule : rules) {
				ruleFound = credential.contains(rule, annotation.get().access());
				if (ruleFound != null) {
					return;
				}				
			}
			
			throw TypeExposeBusinessException.NAO_AUTORIZADO.buildException();
		}
	}

}
