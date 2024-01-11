package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.Users;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepoTest {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		 Role roleAdmin= entityManager.find(Role.class, 1);
		Users user1 =new Users("rashmi@gmail.com","Rashmi","Ramjan","Rashmi@12");
		user1.addRole(roleAdmin);
	 Users savedUser1=	userRepo.save(user1);
		assertThat(savedUser1.getId()).isGreaterThan(0);
		
		
	}
	@Test
	public void testCreateUser2() {
	
		Users user2 =new Users("raaja@gmail.com","Raju","Ranjan","Rashmi@12");
		Role role2=new Role(2);
		Role role3=new Role(3);
		user2.addRole(role2);
		user2.addRole(role3);
		 Users savedUser2=	userRepo.save(user2);
		assertThat(savedUser2.getId()).isGreaterThan(0);
		
		
	}
	@Test
	public void deleteUserById() {
		userRepo.deleteById(1);
		
		
	}



}
