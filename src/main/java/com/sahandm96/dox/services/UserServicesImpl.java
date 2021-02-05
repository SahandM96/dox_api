package com.sahandm96.dox.services;


import com.kavenegar.sdk.KavenegarApi;
import com.sahandm96.dox.domain.ERole;
import com.sahandm96.dox.domain.Role;
import com.sahandm96.dox.domain.User;
import com.sahandm96.dox.domain.dto.UserResponseDTO;
import com.sahandm96.dox.payload.response.RestMessages;
import com.sahandm96.dox.repository.RoleRepository;
import com.sahandm96.dox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class UserServicesImpl implements UserServices, UserDetailsService {


    KavenegarApi api = new KavenegarApi("3641337041473744336253464E35556B3631683451754D306F36344344416754");
    final String sender = "10002020002022";

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepo;


    public UserServicesImpl(UserRepository repo, PasswordEncoder passwordEncoder, RoleRepository roleRepo) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
        this.roleRepo = roleRepo;
    }

    @Override
    public RestMessages saveAdmin(User user) {
        RestMessages RestMessages = new RestMessages();
        if (!this.repo.existsByUsername(user.getUsername()) || !this.repo.existsByEmail(user.getEmail())) {
            api.send(sender, user.getUsername(), "به جمع کاربران رستوارن های روباه خوش آمدید");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            List<Role> Auth = new ArrayList<>();
            Auth.add(new Role(ERole.ROLE_ADMIN));
            user.setRoles(Auth);

            repo.save(user);

            UserResponseDTO userR = new UserResponseDTO(user);
            return RestMessages.SuccessMessage("Admin Created", userR, "200");
        } else {
            return RestMessages.NotFoundMessage("UserName Taken");
        }
    }

    @Override
    public RestMessages saveCustomer(User user) {
        RestMessages RestMessages = new RestMessages();
        if (!this.repo.existsByUsername(user.getUsername()) || !this.repo.existsByEmail(user.getEmail())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            api.send(sender, user.getUsername(), "به جمع کاربران رستوارن های روباه خوش آمدید");
            List<Role> Auth = new ArrayList<>();
            Auth.add(new Role(ERole.ROLE_COSTUMER));
            user.setRoles(Auth);
            repo.save(user);
            UserResponseDTO userR = new UserResponseDTO(user);
            return RestMessages.SuccessMessage("COSTUMER Created", userR, "200");
        } else {
            return RestMessages.NotFoundMessage("UserName Taken");
        }
    }

    @Override
    public RestMessages saveManager(User user) {
        RestMessages RestMessages = new RestMessages();
        if (!this.repo.existsByUsername(user.getUsername()) || !this.repo.existsByEmail(user.getEmail())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            api.send(sender, user.getUsername(), "به جمع کاربران رستوارن های روباه خوش آمدید");
            List<Role> Auth = new ArrayList<>();
            Auth.add(new Role(ERole.ROLE_MANAGER));
            user.setRoles(Auth);
            repo.save(user);
            UserResponseDTO userR = new UserResponseDTO(user);
            return RestMessages.SuccessMessage("COSTUMER Created", userR, "200");
        } else {
            return RestMessages.NotFoundMessage("UserName Taken");
        }
    }

    @Override
    public RestMessages updateUser(User user) {
        RestMessages restMessages = new RestMessages();
        User localUser;
        if (this.repo.existsByUsername(user.getUsername()) || this.repo.existsByEmail(user.getEmail())) {
            localUser = this.repo.findByUsername(user.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Not Found"));
            this.repo.save(localUser);
            api.send(sender, user.getUsername(), "کاربر به روز رسانی شد");
            UserResponseDTO userR = new UserResponseDTO(user);
            return restMessages.SuccessMessage("User  Updated", userR, "200");
        } else {
            return restMessages.NotFoundMessage("User Not Found");
        }
    }

    @Override
    public RestMessages addToAdmin(User user) {
        RestMessages restMessages = new RestMessages();
        User localUser;
        if (this.repo.existsByUsername(user.getUsername()) || this.repo.existsByEmail(user.getEmail())) {
            localUser = this.repo.findByUsername(user.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Not Found"));
            List<Role> Auth;
            Auth = user.getRoles();
            Auth.add(new Role(ERole.ROLE_ADMIN));
            user.setRoles(Auth);
            this.repo.save(localUser);
            api.send(sender, user.getUsername(), "کاربر به روز رسانی شد");
            UserResponseDTO userR = new UserResponseDTO(user);
            return restMessages.SuccessMessage("User  Updated", userR, "200");
        } else {
            return restMessages.NotFoundMessage("User Not Found");
        }
    }

    @Override
    public RestMessages addToManger(User user) {
        RestMessages restMessages = new RestMessages();
        User localUser;
        if (this.repo.existsByUsername(user.getUsername()) || this.repo.existsByEmail(user.getEmail())) {
            localUser = this.repo.findByUsername(user.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Not Found"));
            List<Role> Auth;
            Auth = user.getRoles();
            Auth.add(new Role(ERole.ROLE_MANAGER));
            user.setRoles(Auth);
            this.repo.save(localUser);
            api.send(sender, user.getUsername(), "کاربر به روز رسانی شد");
            UserResponseDTO userR = new UserResponseDTO(user);
            return restMessages.SuccessMessage("User  Updated", userR, "200");
        } else {
            return restMessages.NotFoundMessage("User Not Found");
        }
    }


    @Override
    public RestMessages makeItCustomer(User user) {
        RestMessages restMessages = new RestMessages();
        User localUser;
        if (this.repo.existsByUsername(user.getUsername()) || this.repo.existsByEmail(user.getEmail())) {
            localUser = this.repo.findByUsername(user.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Not Found"));
            List<Role> Auth = new ArrayList<>();
            Auth.add(new Role(ERole.ROLE_COSTUMER));
            user.setRoles(Auth);
            this.repo.save(localUser);
            api.send(sender, user.getUsername(), "کاربر به روز رسانی شد");
            UserResponseDTO userR = new UserResponseDTO(user);
            return restMessages.SuccessMessage("User  Updated", userR, "200");
        } else {
            return restMessages.NotFoundMessage("User Not Found");
        }
    }

    @Override
    public RestMessages revokeFromAdmin(User user) {
        RestMessages restMessages = new RestMessages();
        User localUser;
        if (this.repo.existsByUsername(user.getUsername()) || this.repo.existsByEmail(user.getEmail())) {
            localUser = this.repo.findByUsername(user.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Not Found"));
            List<Role> Auth;
            Auth = user.getRoles();
            if (user.getRoles().contains(new Role(ERole.ROLE_ADMIN))) {
                Auth.remove(new Role(ERole.ROLE_ADMIN));
                user.setRoles(Auth);
            }
            this.repo.save(localUser);
            api.send(sender, user.getUsername(), "کاربر به روز رسانی شد");
            UserResponseDTO userR = new UserResponseDTO(user);
            return restMessages.SuccessMessage("User  Updated", userR, "200");
        } else {
            return restMessages.NotFoundMessage("User Not Found");
        }
    }

    @Override
    public RestMessages revokeFromManager(User user) {
        RestMessages restMessages = new RestMessages();
        User localUser;
        if (this.repo.existsByUsername(user.getUsername()) || this.repo.existsByEmail(user.getEmail())) {
            localUser = this.repo.findByUsername(user.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Not Found"));
            List<Role> Auth;
            Auth = user.getRoles();
            if (user.getRoles().contains(new Role(ERole.ROLE_MANAGER))) {
                Auth.remove(new Role(ERole.ROLE_MANAGER));
                user.setRoles(Auth);
            }
            this.repo.save(localUser);
            api.send(sender, user.getUsername(), "کاربر به روز رسانی شد");
            UserResponseDTO userR = new UserResponseDTO(user);
            return restMessages.SuccessMessage("User  Updated", userR, "200");
        } else {
            return restMessages.NotFoundMessage("User Not Found");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo
                .findByUsername(username)
                .map(u -> new org.springframework.security.core.userdetails.User(
                        u.getUsername(),
                        u.getPassword(),
                        u.getActive(),
                        u.getActive(),
                        u.getActive(),
                        u.getActive(),
                        AuthorityUtils.createAuthorityList(
                                u.getRoles()
                                        .stream()
                                        .map(r -> r.getName().toString())
                                        .collect(Collectors.toList())
                                        .toArray(new String[]{}))))
                .orElseThrow(() -> new UsernameNotFoundException("No user with "
                        + "the name " + username + "was found in the database"));
    }
}

