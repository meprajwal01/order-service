package com.home.orderservice.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KakfaConfiguration {

/*	@Bean
	public ProducerFactory<String, Order> producerFactory() {
		Map<String, Object> config = new HashMap<>();

		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		return new DefaultKafkaProducerFactory<>(config);
	}

	@Bean
	public KafkaTemplate<String, Order> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}*/

}
