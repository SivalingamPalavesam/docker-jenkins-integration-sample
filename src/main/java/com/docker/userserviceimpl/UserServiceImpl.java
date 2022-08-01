package com.docker.userserviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.docker.entity.User;
import com.docker.exception.CustomException;
import com.docker.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl 
{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository ;


	public User saveUser(User user) {
		log.info("Save User {}", user);

		if (user.getId() != null) 
		{
			throw new CustomException("New User Shouldn't Have An Id", HttpStatus.BAD_REQUEST);
		}
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		log.info("Update User {} ", user);
		if (user.getId() == null) {
			throw new CustomException("New User Must Have An Id", HttpStatus.BAD_REQUEST);
		}
		getUserById(user.getId());
		return userRepository.save(user);
	}

	public User getUserById(Long id) 
	{
		log.info("Get User For The Id {} ", id);
		return userRepository
				.findById(id)
				.orElseThrow(() -> new CustomException("User Not Found For The Id "
						.concat(String.valueOf(id)), HttpStatus.NOT_FOUND));
	}

	public List<User> getAllUsers() {
		log.info("Get All Users");
		return userRepository
				.findAll();
	}

	public void deleteUserById(Long id) {
		log.info("Delete User For The Id {} ", id);
		userRepository
		.delete(getUserById(id));
	}
}
