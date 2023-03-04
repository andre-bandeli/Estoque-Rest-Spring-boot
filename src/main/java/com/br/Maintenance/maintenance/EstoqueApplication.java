package com.br.Maintenance.maintenance;

//import com.br.Maintenance.maintenance.model.user.Authority;
//import com.br.Maintenance.maintenance.model.user.User;
//import com.br.Maintenance.maintenance.repository.auth.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EstoqueApplication {

//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@Autowired
//	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class, args);
	}

//	@PostConstruct
//	protected void init() {
//
//		List<Authority> authorityList=new ArrayList<>();
//
//		authorityList.add(createAuthority("USER","User role"));
//		//authorityList.add(createAuthority("ADMIN","Admin role"));
//
//		User user=new User();
//		user.setUserName("username");
//		user.setEmail("teste@teste.com");
//		user.setPassword(passwordEncoder.encode("password"));
//		user.setEnabled(true);
//		user.setAuthorities(authorityList);
//		userRepository.save(user);
//
//	}
//	private Authority createAuthority(String roleCode,String roleDescription) {
//		Authority authority=new Authority();
//		authority.setRoleCode(roleCode);
//		authority.setRoleDescription(roleDescription);
//		return authority;
//	}

}
