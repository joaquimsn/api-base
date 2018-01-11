package br.sp.senac.apibase.main.exceptions;

/**
 * Classe utilizar como modelo de respota para 
 * as variações de retorno da aplicação 
 * @author Joaquim Neto
 *
 */
public class MessageResponseError {

	private String systemCode;
	private int codeHttp;
	private String message;
	private String detail;

	private MessageResponseError(String systemCode, int codeHttp, String message, String detail) {
		this.message = message;
		this.systemCode = systemCode;
		this.codeHttp = codeHttp;
		this.detail = detail;
	}

	public static MessageResponseError of(String systemCode, int codeHttp, String message, String detail) {
		return new MessageResponseError(systemCode, codeHttp, message, detail);
	}
	
	public static MessageResponseError of(String systemCode, int codeHttp, String message) {
		return new MessageResponseError(systemCode, codeHttp, message, "");
	}

	public String getSystemCode() {
		return systemCode;
	}

	public int getCodeHttp() {
		return codeHttp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetail() {
		return detail;
	}

	@Override
	public String toString() {
		return "MessageResponseException [systemCode=" + systemCode + ", codeHttp=" + codeHttp + ", message=" + message
				+ ", detail=" + detail + "]";
	}
}
