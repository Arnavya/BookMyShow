package com.sst.bookmyshowsst.repositories;

import com.sst.bookmyshowsst.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {  //(<Model with which you want to interact with, Datatype of PK>)//

    Optional<User> findByEmail(String email);// will operate as this in background //Select * from users where email = email;

    @Override
    User save(User user);
}
