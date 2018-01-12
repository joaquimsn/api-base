package br.sp.senac.apibase.expose.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.sp.senac.apibase.expose.security.enums.Access;

public class Rule {
	private String code;
	private String name;
	private List<Access> accesses;
	
	public boolean containsAny(Access[] ruleAccess) {
		for (Access access : ruleAccess) {
			if (getAccesses().contains(access)) {
				return true;
			}
		}
		
		return false;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public List<Access> getAccesses() {
		return Optional.ofNullable(this.accesses).orElse(new ArrayList<Access>());
	}

	@Override
	public String toString() {
		return "Rule [code=" + code + ", name=" + name + ", access=" + accesses + "]";
	}
}
