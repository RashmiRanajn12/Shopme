package com.shopme.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Users;

@Service
public class UserService {
	@Autowired
   private UserRepo userRepo;
	public List<Users> lisrAll(){
		return (List<Users>)userRepo.findAll();
	}
}
