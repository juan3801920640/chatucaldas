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
import com.chatUcaldas.chat_ucaldas.entity.Chat;
import com.chatUcaldas.chat_ucaldas.entity.Question;
import com.chatUcaldas.chat_ucaldas.entity.Role;
import com.chatUcaldas.chat_ucaldas.entity.UserChat;
import com.chatUcaldas.chat_ucaldas.service.ChatServiceImpl;
import com.chatUcaldas.chat_ucaldas.service.QuestionServiceImpl;
import com.chatUcaldas.chat_ucaldas.service.RoleServiceImpl;
import com.chatUcaldas.chat_ucaldas.service.UserChatServiceImpl;

@RestController
@RequestMapping("/chat-ucaldas")
@CrossOrigin(origins="*")
public class ChatController {
	
	@Autowired
	@Qualifier("RoleServiceImpl")
	private RoleServiceImpl roleService;
	
	@Autowired
	@Qualifier("UserChatServiceImpl")
	private UserChatServiceImpl userChatService;
	
	@Autowired
	@Qualifier("ChatServiceImpl")
	private ChatServiceImpl chatService;
	
	@Autowired
	@Qualifier("QuestionServiceImpl")
	private QuestionServiceImpl questionService;
	
	
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
	
	//Chat -----------------------------------
	
	@PostMapping(path="/newChat", produces={"application/json"})
	@CrossOrigin(methods= { RequestMethod.POST })
	public ResponseEntity<?> newChat(@RequestBody Chat chat) throws Exception {
		try {
			return new ResponseEntity<Chat>(chatService.addChat(chat), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/findChatById/{id}", produces={"application/json"})
	@CrossOrigin(methods = { RequestMethod.GET })
	public ResponseEntity<?> getChatById(@PathVariable Long id) throws Exception {
		try {
			return new ResponseEntity<Chat>(chatService.getChat(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/countQuestByChatById/{id}", produces={"application/json"})
	@CrossOrigin(methods = { RequestMethod.GET })
	public ResponseEntity<?> countQuest(@PathVariable Long id) throws Exception {
		try {
			return new ResponseEntity<Integer>(chatService.getChat(id).getQuestions().size(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping(path="/findAllChats", produces={"application/json"})
	@CrossOrigin(methods = { RequestMethod.GET })
	public ResponseEntity<?> getAllChats() throws Exception {
		try {
			return new ResponseEntity<List<Chat>>(chatService.getAllChats(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//Questions -----------------------------------
	
	@PostMapping(path="/newQuestion", produces={"application/json"})
	@CrossOrigin(methods= { RequestMethod.POST })
	public ResponseEntity<?> newQuestion(@RequestBody Question question) throws Exception {
		try {
			return new ResponseEntity<Question>(questionService.addQuestion(question), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/findAllQuestions", produces={"application/json"})
	@CrossOrigin(methods = { RequestMethod.GET })
	public ResponseEntity<?> getAllQuestions() throws Exception {
		try {
			return new ResponseEntity<List<Question>>(questionService.getAllQuestions(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
