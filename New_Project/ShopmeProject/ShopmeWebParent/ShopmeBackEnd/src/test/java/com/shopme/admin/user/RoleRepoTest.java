package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class RoleRepoTest {
	@Autowired
	private RoleRepo roleRepo;
	
	@Test
	public void testCreateFirstRole() {
		Role  roleAdmin =new  Role("Admin","manage everything");
		 Role saveRole=roleRepo.save(roleAdmin);
		assertThat(saveRole.getId()).isGreaterThan(0);
		
	}
	@Test
	public void testCreateRestRole() {
		Role  roleSalePersons =new  Role("Salesperson","manage product price,customers");
		Role  roleEditor =new  Role("Editor","manage categories,brands");
		Role  roleShipper =new  Role("Shiper","view products,view orders and update order");
		Role  roleAssistant =new  Role("Assistant","manage questions and reviews");
		roleRepo.saveAll(List.of(roleSalePersons,roleEditor,roleShipper,roleAssistant));
		
		
	}


}
