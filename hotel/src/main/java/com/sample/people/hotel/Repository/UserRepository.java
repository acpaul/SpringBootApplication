package com.sample.people.hotel.Repository;

import com.sample.people.hotel.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>
    {
	User findByUserName(String userName);
}