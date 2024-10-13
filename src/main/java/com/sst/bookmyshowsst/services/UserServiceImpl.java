package com.sst.bookmyshowsst.services;

import com.sst.bookmyshowsst.dtos.ResponseStatus;
import com.sst.bookmyshowsst.models.User;
import com.sst.bookmyshowsst.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User signup(String name, String email, String password) {
        //First check if User with the given email is already present in the DB or not.
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            //redirect to login page
            return optionalUser.get();
        }
        //If user is not present in the DB create a User with the given details and save it in the DB.
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        //Password should be stored in th database after encryption.
        //For now we are storing password as it is in the DB, we can use BCryptPasswordEncoder to encode the password.
        user.setPassword(password);
        return userRepository.save(user);
    }

    @Override
    public ResponseStatus login(String email, String inputPassword) {
        //First fetch the user in the database by emailId
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()){
            //Redirect to signup
        }
        User user = optionalUser.get();
        if(user.getPassword().equals(inputPassword)){
            //Login successfull
            return ResponseStatus.SUCCESS;
        }
        return ResponseStatus.FAILURE;
    }

}
