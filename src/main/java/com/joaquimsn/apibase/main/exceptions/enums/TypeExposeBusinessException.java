package com.joaquimsn.apibase.main.exceptions.enums;

import java.util.Objects;

import com.joaquimsn.apibase.main.exceptions.ExposeBusinessException;
import com.joaquimsn.apibase.main.exceptions.SenacHttpStatusCode;

public enum TypeExposeBusinessException {

	CAMPOS_OBRIGATORIOS("geral.campoObrigatorios", "Existem campos obrigatórios não preenchidos", SenacHttpStatusCode.CONTRATO_VIOLADO), 
	NAO_ENCONTRATO("geral.dadoNaoEncontrado", "Dado não encontrado", SenacHttpStatusCode.RECURSO_NAO_ENCONTRADO), 
	REGRA_SENAC("entity.regraNegocio", "Regra de negócio violada", SenacHttpStatusCode.VALIDACAO_CAMPOS),
	NAO_AUTORIZADO("autenticacao.naoAutorizado", "", SenacHttpStatusCode.NAO_AUTORIZADO),
	TOKEN_OBRIGATORIO("autenticacao.token.obrigatorio", "Autenticação necessaria, token não encontrado no header param authorization", SenacHttpStatusCode.NAO_AUTENTICADO);

	private String codigoSistema;
	private String message;
	private int codigoHttp;

	TypeExposeBusinessException(String codigoSistema, String message, int codigoHttp) {
		this.codigoSistema = codigoSistema;
		this.message = message;
		this.codigoHttp = codigoHttp;
	}

	/**
	 * Cria uma instancia da BusinessException com o detalhe informado
	 * 
	 * @param detalhe String que será concatenda a mensagem padrão
	 * @return BusinessException
	 */
	public ExposeBusinessException buildException(String detalhe) {
		Objects.requireNonNull(detalhe);
		return ExposeBusinessException.of(detalhe, this.codigoSistema, this.codigoHttp);
	}
	
	public ExposeBusinessException buildException(String detalhe, Throwable cause) {
		Objects.requireNonNull(detalhe);
		return ExposeBusinessException.of(this.codigoSistema, this.message + ": " + detalhe, this.codigoHttp, cause);
	}

	/**
	 * Cria uma BusinessException com uma mensagem padrão
	 * 
	 * @return BusinessException
	 */
	public ExposeBusinessException buildException() {
		return ExposeBusinessException.of(this.codigoSistema, this.message, this.codigoHttp);
	}
	
	public ExposeBusinessException buildException(Throwable cause) {
		return ExposeBusinessException.of(this.codigoSistema, this.message, this.codigoHttp, cause);
	}

	public String getCodigoSistema() {
		return this.codigoSistema;
	}
}
