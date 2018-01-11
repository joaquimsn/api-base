package br.sp.senac.apibase.main.exceptions;

public class ExposeBusinessException extends ApplicationException {

	private static final long serialVersionUID = 8246610249702126170L;
	private int httpStatusCode;

	protected ExposeBusinessException(String businessCode, String message, int httpStatusCode) {
		super(businessCode, message);
		this.httpStatusCode = httpStatusCode;
	}
	
	protected ExposeBusinessException(String businessCode, String message, int httpStatusCode, Throwable cause) {
		super(businessCode, message, cause);
		this.httpStatusCode = httpStatusCode;
	}

	public static ExposeBusinessException of(String businessCode, String message, int httpStatusCode) {
		return new ExposeBusinessException(businessCode, message, httpStatusCode);
	}
	
	public static ExposeBusinessException of(String message, String businessCode, int httpStatusCode, Throwable cause) {
		return new ExposeBusinessException(businessCode, message, httpStatusCode, cause);
	}

	public int getHttpStatusCode() {
		return this.httpStatusCode;
	}
}
