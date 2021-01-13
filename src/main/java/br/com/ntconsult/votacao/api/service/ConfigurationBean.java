package br.com.ntconsult.votacao.api.service;

import org.springframework.stereotype.Component;

@Component
public class ConfigurationBean {

	public String getUrlValidarCpf(String cpf) {
		return "https://user-info.herokuapp.com/users/" + cpf;
	}

}
