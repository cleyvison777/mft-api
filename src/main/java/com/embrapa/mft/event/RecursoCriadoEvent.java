package com.embrapa.mft.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriadoEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;
	private HttpServletResponse response;
	private Long Codigo;

	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long Codigo) {
		super(source);
		this.response = response;
		this.Codigo = Codigo;
		
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getCodigo() {
		return Codigo;
	}

}
