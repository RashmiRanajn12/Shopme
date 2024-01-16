package com.shopme.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopme.common.entity.Role;
import com.shopme.common.entity.Users;

@Service
public class UserService {
	@Autowired
   private UserRepo userRepo;
	@Autowired
	private RoleRepo roleRepo;
	public List<Users> lisrAll(){
		return (List<Users>)userRepo.findAll();
	}
	public List<Role> listAll(){
		return (List<Role>)roleRepo.findAll();
				
	}
	public void saveUser(Users user) {
		userRepo.save(user);
	}
}
