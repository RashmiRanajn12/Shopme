package com.shopme.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.shopme.common.entity.Role;
import com.shopme.common.entity.Users;

@Service
public class UserService {
	@Autowired
   private UserRepo userRepo;
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Users> lisrAll(){
		return (List<Users>)userRepo.findAll();
	}
	public List<Role> listAll(){
		return (List<Role>)roleRepo.findAll();
				
	}
	public void saveUser(Users user){
		encodePassword(user);
		userRepo.save(user);
	}
  private  void encodePassword(Users user) {
	  String encodedPassword =passwordEncoder.encode(user.getPassword());
	  user.setPassword(encodedPassword);
  }
  public boolean isEmailUnique(String email) {
	  Users userByemail =userRepo.getUserByEmail(email);
	  return userByemail.equals(null);
	  
  }
}
