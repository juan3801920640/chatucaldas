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
import com.chatUcaldas.chat_ucaldas.entity.Chat;
import com.chatUcaldas.chat_ucaldas.service.ChatServiceImpl;

@RestController
@RequestMapping("/chat-ucaldas")
@CrossOrigin(origins="*")
public class ChatControllerChats {
	
	@Autowired
	@Qualifier("ChatServiceImpl")
	private ChatServiceImpl chatService;
	
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
	
	
	@GetMapping(path="/findChatByUserId/{userId}", produces={"application/json"})
	@CrossOrigin(methods = { RequestMethod.GET })
	public ResponseEntity<?> getChatByUserId(@PathVariable Long userId) throws Exception {
		try {
			return new ResponseEntity<List<Chat>>(chatService.getChatByUserChatId(userId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		

}
