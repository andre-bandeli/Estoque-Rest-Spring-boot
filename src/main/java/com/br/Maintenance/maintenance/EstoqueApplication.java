package com.br.Maintenance.maintenance;

import com.br.Maintenance.maintenance.model.*;
import com.br.Maintenance.maintenance.model.user.Authority;
import com.br.Maintenance.maintenance.model.user.User;
import com.br.Maintenance.maintenance.repository.auth.UserRepository;
import com.br.Maintenance.maintenance.service.AtivoService;
import com.br.Maintenance.maintenance.service.OrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class EstoqueApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class, args);
	}

	@PostConstruct
	protected void init() {

		List<Authority> authorityList=new ArrayList<>();

		authorityList.add(createAuthority("USER","User role"));
		//authorityList.add(createAuthority("ADMIN","Admin role"));

		User user=new User();
		user.setUserName("username10");
		user.setEmail("teste10@teste.com");
		user.setPassword(passwordEncoder.encode("password"));
		System.out.println(user.getPassword());
		user.setEnabled(true);
		user.setAuthorities(authorityList);
		userRepository.save(user);

	}

	private Authority createAuthority(String roleCode,String roleDescription) {
		Authority authority=new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}

}
