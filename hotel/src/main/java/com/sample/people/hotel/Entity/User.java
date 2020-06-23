package com.sample.people.hotel.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "username", unique=true)
    private String userName;

    @Column(name = "fname")
    private String firstName;

    @Column(name = "lname")
    private String lastName;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "email")
    private String email;

    @Column(name = "password" )
    private String password;

	/*
	 * public Integer getId() { return id; }
	 * 
	 * public void setId(final Integer id) { this.id = id; }
	 * 
	 * public String getFirstName() { return firstName; } public void
	 * setFirstName(final String firstName) { this.firstName = firstName; }
	 * 
	 * public String getUserName() { return userName; } public void
	 * setUserName(final String userName) { this.userName = userName; }
	 * 
	 * public String getLastName() { return lastName; }
	 * 
	 * public void setLastName(final String lastName) { this.lastName = lastName; }
	 * 
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(final String email) { this.email = email; }
	 * 
	 * public Date getDob() { return dob; }
	 * 
	 * public void setDob(final Date dob) { this.dob = dob; }
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * public void setPassword(final String password) { this.password = password; }
	 */

}