package com.sahandm96.dox.controllers;


import com.sahandm96.dox.domain.User;
import com.sahandm96.dox.payload.response.RestMessages;
import com.sahandm96.dox.services.UserServices;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {
    private final UserServices userServices;

    public UsersController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping({"/register/Customer"})
    @ResponseBody
    public RestMessages saveCostumer(@RequestBody User user) {
        return this.userServices.saveCustomer(user);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @PostMapping({"/register/Admin"})
    @ResponseBody
    public RestMessages saveAdmin(@RequestBody User user) {
        return this.userServices.saveAdmin(user);
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping({"/register/Manager"})
    @ResponseBody
    public RestMessages saveManager(@RequestBody User user) {
        return this.userServices.saveManager(user);
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @PostMapping({"/user/update"})
    @ResponseBody
    public RestMessages updateUser(@RequestBody User user) {
        return this.userServices.updateUser(user);
    }


    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @PostMapping({"/user/addToAdmin"})
    @ResponseBody
    public RestMessages addToAdmin(@RequestBody User user) {
        return this.userServices.addToAdmin(user);
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping({"/user/addToManger"})
    @ResponseBody
    public RestMessages addToManger(@RequestBody User user) {
        return this.userServices.addToManger(user);
    }


    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    @PostMapping({"/user/makeItCustomer"})
    @ResponseBody
    public RestMessages makeItCustomer(@RequestBody User user) {
        return this.userServices.makeItCustomer(user);
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping({"/user/revokeFromAdmin"})
    @ResponseBody
    public RestMessages revokeFromAdmin(@RequestBody User user) {
        return this.userServices.revokeFromAdmin(user);
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping({"/user/revokeFromManager"})
    @ResponseBody
    public RestMessages revokeFromManager(@RequestBody User user) {
        return this.userServices.revokeFromManager(user);
    }

}
