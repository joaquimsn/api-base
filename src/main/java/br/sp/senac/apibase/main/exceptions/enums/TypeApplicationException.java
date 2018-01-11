package br.sp.senac.apibase.main.exceptions.enums;

import br.sp.senac.apibase.main.exceptions.ApplicationException;
import br.sp.senac.apibase.main.exceptions.FatalErroStartupApplicationException;

public enum TypeApplicationException {
	GENERIC_ERROR("applicaton.erro.inesperado", "Erro inesperado, tente novamente", FatalErroStartupApplicationException.class),
	STARTUP_ERROR("applicaton.fatal.startup", "Não foi possível iniciar a aplicação", FatalErroStartupApplicationException.class),
	EMAIL_ERROR("email.send.erro", "Erro no envio de email", ApplicationException.class),
	PERSISTENCIA("application.dao.erro", "Erro na camada de persistência", ApplicationException.class),
	FATAL("senac.system.fatal", "Falha interna", ApplicationException.class),
	ERRO_SALVAR_ARQUIVO("application.erro.gerenciadorArquivo", "Falha ao salvar o arquivo", ApplicationException.class),
	ERRO_CARREGAR_ARQUIVO("application.erro.carregarArquivo", "Não foi possível carregar o arquivo", ApplicationException.class);
	
	private String codigo;
	private String mensagem;
	private Class<?> classException;

	private TypeApplicationException(String codigo, String mensagem, Class<?> classException) {
		this.codigo = codigo;
		this.mensagem = mensagem;
		this.classException = classException;
	}

	public ApplicationException buildException() {
		if (classException.isAssignableFrom(ApplicationException.class)) {
			return ApplicationException.of(this.codigo, this.mensagem);
		}
		
		return FatalErroStartupApplicationException.of(this.codigo, this.mensagem);
	}
	
	public ApplicationException buildException(String mensagem) {
		if (classException.isAssignableFrom(ApplicationException.class)) {
			return ApplicationException.of(this.codigo, this.mensagem + ": " + mensagem);
		}
		
		return FatalErroStartupApplicationException.of(this.codigo, this.mensagem + ": " + mensagem);
	}
	
	public String getCodigo(){
		return this.codigo;
	}
	
	public String getMensagem() {
		return mensagem;
	}
}
