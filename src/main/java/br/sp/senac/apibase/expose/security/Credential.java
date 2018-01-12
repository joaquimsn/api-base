package br.sp.senac.apibase.expose.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.sp.senac.apibase.expose.security.enums.Access;

public class Credential {
	private String code;
	private String user;
	private String application;
	private List<Rule> rules;

	public Rule contains(br.sp.senac.apibase.expose.security.enums.Rule rule, Access[] accesses) {
		List<Rule> rulesFound = getRules().stream().filter(credentialRule -> 
			credentialRule.getCode().equals(rule.getCode()) && credentialRule.containsAny(accesses)
		).collect(Collectors.toList());
		
		return rulesFound.isEmpty() ? null : rulesFound.get(0);
	}
	
	public String getCode() {
		return code;
	}

	public String getUser() {
		return user;
	}

	public String getApplication() {
		return application;
	}

	public List<Rule> getRules() {
		return Optional.ofNullable(this.rules).orElse(new ArrayList<>());
	}
}
