package br.sp.senac.apibase.expose.security.enums;

public enum Rule {
	DEFAULT("DEFAULT");
	
	private String code;

	private Rule(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
