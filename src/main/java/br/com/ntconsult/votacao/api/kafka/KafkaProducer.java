package br.com.ntconsult.votacao.api.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer{

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	String topic = "topic_notificacao";

	public void sendMessage(String msg) {
	    kafkaTemplate.send(topic, msg);
	}

}
