package com.yessinfotech.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yessinfotech.entity.User;
import com.yessinfotech.repository.UserRepository;
import com.yessinfotech.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User registerUser(User user) {

        user.setRole("ADMIN");

        return repository.save(user);
    }

    

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return repository.findByUsernameAndPassword(username,password);
	}

}