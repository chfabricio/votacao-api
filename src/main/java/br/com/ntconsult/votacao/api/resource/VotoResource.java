package br.com.ntconsult.votacao.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ntconsult.votacao.api.model.vo.VotoVO;
import br.com.ntconsult.votacao.api.service.VotoService;

@RestController
@RequestMapping("/api/1.0/voto")
public class VotoResource {

	@Autowired
	private VotoService service;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public void criar(@RequestBody VotoVO request) {
		service.criar(request);
	}
}
