package com.chatUcaldas.chat_ucaldas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.chatUcaldas.chat_ucaldas.entity.Role;
import com.chatUcaldas.chat_ucaldas.service.RoleServiceImpl;


@RestController
@RequestMapping("/chat-ucaldas")
@CrossOrigin(origins="*")
public class ChatControllerRoles {
	
	@Autowired
	@Qualifier("RoleServiceImpl")
	private RoleServiceImpl roleService;
	
	//Roles -----------------------------------
	
	@PostMapping(path="/newRole", produces={"application/json"})
	@CrossOrigin(methods= { RequestMethod.POST })
	public ResponseEntity<?> newRole(@RequestBody Role role) throws Exception {
		try {
				
			return new ResponseEntity<Role>(roleService.addRole(role), HttpStatus.OK);
			
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/findRoleById/{id}", produces={"application/json"})
	@CrossOrigin(methods = { RequestMethod.GET })
	public ResponseEntity<?> getRoleById(@PathVariable Long id) throws Exception {
		try {
			
			return new ResponseEntity<Role>(roleService.getRole(id), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/findAllRoles", produces={"application/json"})
	@CrossOrigin(methods = { RequestMethod.GET })
	public ResponseEntity<?> getAllRoles() throws Exception {
		try {

			return new ResponseEntity<List<Role>>(roleService.getAllRoles(), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
		
}
