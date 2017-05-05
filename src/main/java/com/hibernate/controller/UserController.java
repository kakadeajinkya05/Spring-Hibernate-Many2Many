package com.hibernate.controller;

import java.io.IOException;
import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.domain.CardDetails;
import com.hibernate.domain.UserDetails;
import com.hibernate.repository.CardRepository;
import com.hibernate.repository.UserRepository;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	SessionFactory sf;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CardRepository cardRepository;
	
	@PostMapping("/PostUser")
//	@RequestMapping(value="/PostUser",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE})
	public UserDetails postUser(@RequestBody UserDetails user){
		
		return userRepository.save(user);
	} 
	
	
	
	@GetMapping("/GetUser")
	public Collection<UserDetails> getUser() throws IOException{
		return userRepository.findAllData();
	} 
	
	@GetMapping("/GetCard")
	public Collection<CardDetails> getCard() throws IOException{
		return cardRepository.findAll();
	} 
	
	@PostMapping("/PostCard")
	public CardDetails postCard(@RequestBody CardDetails cardDetails){
		return cardRepository.save(cardDetails);
	} 
	
}
