package com.sahandm96.dox;

import com.sahandm96.dox.domain.ERole;
import com.sahandm96.dox.domain.Role;
import com.sahandm96.dox.domain.User;
import com.sahandm96.dox.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;

    public CommandLineAppStartupRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private static final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    @Override
    public void run(String... args) throws Exception {
        List<Role> Auth = new ArrayList<>();
        Auth.add(new Role(ERole.ROLE_ADMIN_ECO));
        Auth.add(new Role(ERole.ROLE_MANAGER));
        Auth.add(new Role(ERole.ROLE_VERIFIED));
//        this.userRepository.save(new User("sahandm96",
//                passwordEncoder.encode("password"), Auth, true));
//        this.branchRepository.save(new Branch("main", "Test",
//                new UserResponseDTO(this.userRepository.findByUsername("SAdmin").get()), menuServices.getMenus()));
    }


}
