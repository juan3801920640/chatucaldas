package com.chatUcaldas.chat_ucaldas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chatUcaldas.chat_ucaldas.entity.Question;
import com.chatUcaldas.chat_ucaldas.service.QuestionServiceImpl;

@RestController
@RequestMapping("/chat-ucaldas")
@CrossOrigin(origins="*")
public class ChatControllerQuest {
	
	@Autowired
	@Qualifier("QuestionServiceImpl")
	private QuestionServiceImpl questionService;
	
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
