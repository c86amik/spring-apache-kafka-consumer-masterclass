/**
 * 
 */
package com.springcavaj.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcavaj.kafka.model.User;

/**
 * @author springcavaj
 *
 */
@Repository
public interface SpringApacheKafkaCrudRepository extends JpaRepository<User, Long> {

}
