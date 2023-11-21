package com.chatUcaldas.chat_ucaldas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatUcaldas.chat_ucaldas.entity.UserChat;
import com.chatUcaldas.chat_ucaldas.service.UserChatServiceImpl;

@RestController
@RequestMapping("/chat-ucaldas")
@CrossOrigin(origins="*")
public class ChatControllerUsers {
	
	@Autowired
	@Qualifier("UserChatServiceImpl")
	private UserChatServiceImpl userChatService;
	
	//User Chat -----------------------------------
	
	
	@PostMapping(path="/newUserChat", produces={"application/json"})
	@CrossOrigin(methods= { RequestMethod.POST })
	public ResponseEntity<?> newUserChat(@RequestBody UserChat userChat) throws Exception {
		try {
			return new ResponseEntity<UserChat>(userChatService.addUserChat(userChat), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(path="/findUserChatById/{id}", produces={"application/json"})
	@CrossOrigin(methods = { RequestMethod.GET })
	public ResponseEntity<?> getUserChatById(@PathVariable Long id) throws Exception {
		try {
			
			return new ResponseEntity<UserChat>(userChatService.getUserChat(id), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/findAllUsersChat", produces={"application/json"})
	@CrossOrigin(methods = { RequestMethod.GET })
	public ResponseEntity<?> getAllUserChats() throws Exception {
		try {
			
			return new ResponseEntity<List<UserChat>>(userChatService.getAllUserChat(), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path="/deleteUserChat/{id}")
	@CrossOrigin(methods = { RequestMethod.DELETE })
	public ResponseEntity<String> deleteUserChatById(@PathVariable Long id) throws Exception {
		try {
			
			userChatService.deleteUserChat(id);
			return new ResponseEntity<String>("Elemento eliminado", HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path="/updateUserChat", produces={"application/json"})
	@CrossOrigin(methods= { RequestMethod.PUT})
	public ResponseEntity<?> updateUserChat(@RequestBody UserChat newUserChat) throws Exception {
		try {
			return new ResponseEntity<UserChat>(userChatService.updateUserChat(newUserChat), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/login", produces={"application/json"})
	@CrossOrigin(methods = { RequestMethod.GET })
	public ResponseEntity<?> login(@RequestParam String user, @RequestParam String password) throws Exception {
		try {
			return new ResponseEntity<UserChat>(userChatService.login(user, password), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
