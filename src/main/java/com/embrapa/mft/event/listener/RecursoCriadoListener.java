package com.embrapa.mft.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.embrapa.mft.event.RecursoCriadoEvent;
@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent>{

	@Override
	public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
		HttpServletResponse response =  recursoCriadoEvent.getResponse();
		Long codigo = recursoCriadoEvent.getCodigo();
		 adicionarHeaderLocation(response, codigo);
	}

	private void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
				    .buildAndExpand(codigo).toUri();
				     response.setHeader("Location", uri.toASCIIString());
	}

	
}
