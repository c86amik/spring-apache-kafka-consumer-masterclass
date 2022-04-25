/**
 * 
 */
package com.springcavaj.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springcavaj.kafka.model.User;
import com.springcavaj.kafka.model.UserModel;

/**
 * @author springcavaj
 *
 */
@Service
public class SpringApacheKafkaConsumerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringApacheKafkaConsumerService.class);
	
	@Autowired
	private SpringApacheKafkaCrudService apacheKafkaCrudService;
	
	@KafkaListener(topics = "springcavaj-topic", groupId = "group_json",
			containerFactory = "kafkaListenerContainerFactory")
	public void consumeUserModel(UserModel userModel) {
		LOGGER.info("Consume Message from Kafka Topic is : {}", userModel.toString());
		User user = apacheKafkaCrudService.saveUser(userModel);
		LOGGER.info("User after saving in database : {}", user.toString());
	}

}
