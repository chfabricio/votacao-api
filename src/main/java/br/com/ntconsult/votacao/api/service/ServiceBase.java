package br.com.ntconsult.votacao.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class ServiceBase {
	protected @Autowired ConfigurationBean configBean;
	protected @Autowired RestTemplate restTemplate;

}
