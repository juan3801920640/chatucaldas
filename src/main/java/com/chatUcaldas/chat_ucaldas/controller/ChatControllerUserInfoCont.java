package com.chatUcaldas.chat_ucaldas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chatUcaldas.chat_ucaldas.entity.UserInfoContacto;
import com.chatUcaldas.chat_ucaldas.service.UserInfoContactoServiceImpl;

@RestController
@RequestMapping("/chat-ucaldas")
@CrossOrigin(origins="*")
public class ChatControllerUserInfoCont {
	
	@Autowired
	@Qualifier("UserInfoContactoServiceImpl")
	private UserInfoContactoServiceImpl userInfoContService;
	
	//UserInfoContacto ---------------------------------
	@PostMapping(path="/newUserInfoContacto", produces={"application/json"})
	@CrossOrigin(methods= { RequestMethod.POST })
	public ResponseEntity<?> newUserInfoContacto(@RequestBody UserInfoContacto userInfoContacto) throws Exception {
		try {
			return new ResponseEntity<UserInfoContacto>(userInfoContService.addUserInfoContacto(userInfoContacto), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
