package com.embrapa.mft.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mftapi")
public class MftApiProperty {
	//private String originPermitida = "http://frontmft.000webhostapp.com";
	private String originPermitida = "http://localhost:4200";
	private final Seguranca seguranca = new Seguranca();
	
	
	public Seguranca getSeguranca() {
		return seguranca;
	}
	

	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}


	public static class Seguranca {
		
		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
			
	}
	

}
