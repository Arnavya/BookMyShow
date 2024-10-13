package com.sst.bookmyshowsst.services;

import com.sst.bookmyshowsst.dtos.ResponseStatus;
import com.sst.bookmyshowsst.models.User;

public interface UserService {
    User signup(String name, String email, String password);
    ResponseStatus login(String email, String password);
}
