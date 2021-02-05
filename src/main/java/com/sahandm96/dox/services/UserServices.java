package com.sahandm96.dox.services;

import com.sahandm96.dox.domain.User;
import com.sahandm96.dox.payload.response.RestMessages;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserServices {

    RestMessages saveCustomer(User user);

    RestMessages saveAdmin(User user);

    RestMessages saveManager(User user);

    RestMessages updateUser(User user);

    RestMessages addToAdmin(User user);

    RestMessages addToManger(User user);

    RestMessages makeItCustomer(User user);

    RestMessages revokeFromAdmin(User user);

    RestMessages revokeFromManager(User user);

}
