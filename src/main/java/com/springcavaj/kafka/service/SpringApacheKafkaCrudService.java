/**
 * 
 */
package com.springcavaj.kafka.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcavaj.kafka.model.User;
import com.springcavaj.kafka.model.UserModel;
import com.springcavaj.kafka.repository.SpringApacheKafkaCrudRepository;

/**
 * @author springcavaj
 *
 */
@Service
public class SpringApacheKafkaCrudService {
	
	@Autowired
	private SpringApacheKafkaCrudRepository apacheKafkaCrudRepository;
	
	public User saveUser(UserModel userModel) {
		User user = setUserProperties(userModel);
		user = apacheKafkaCrudRepository.save(user);
		return user;
	}
	
	private User setUserProperties(UserModel userModel) {
		User user = new User();
		user.setFirstName(userModel.getFirstName());
		user.setMiddleName(userModel.getMiddleName());
		user.setLastName(userModel.getLastName());
		user.setMobileNo(userModel.getMobileNo());
		user.setEmail(userModel.getEmail());
		user.setPanNo(userModel.getPanNo());
		return user;
	}

}
