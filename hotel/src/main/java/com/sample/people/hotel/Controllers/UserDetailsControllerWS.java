package com.sample.people.hotel.Controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Optional;

import com.sample.people.hotel.Entity.User;
import com.sample.people.hotel.Exception.UserNotFoundException;
import com.sample.people.hotel.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserDetailsControllerWS {
    
    @Autowired
    UserRepository userRepo;
    
    @RequestMapping(value = "customer/{userId}", method = GET)
    public User getCustomerDetail(@PathVariable final Integer userId) throws Exception {
    	final Optional<User> customer = userRepo.findById(userId);
        if (!customer.isPresent())
            throw new UserNotFoundException("Resource Not Found for User id:" + userId);
        return customer.get();
    }
    @RequestMapping(value = "saveCustomerDetails", method = RequestMethod.POST)
    public ResponseEntity<User> saveUserDetails(@RequestBody final User newUser) throws Exception {
    	if(newUser.getUserName()==null||newUser.getPassword()==null) {
    		throw new ResponseStatusException(
  				  HttpStatus.BAD_REQUEST, "User Name and Password Required"
  				);
    	}
    	if(userRepo.findByUserName(newUser.getUserName()) != null) {
    		System.out.println("BAD Request");
    		throw new ResponseStatusException(
    				  HttpStatus.BAD_REQUEST, "User Name already Exist"
    				);
    	}
    	if(newUser.getPassword().length() < 8 || newUser.getPassword().length()>10)
    	{
    		throw new ResponseStatusException(
    				  HttpStatus.BAD_REQUEST, "Password length should be 8-10 character"
    				);
    	}
        System.out.println("New User "+newUser.getFirstName()+"is created");
        userRepo.save(newUser);
        return new ResponseEntity<>(newUser,HttpStatus.OK);
    }  
}