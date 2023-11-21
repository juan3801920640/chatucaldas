package com.chatUcaldas.chat_ucaldas.service;

import java.util.List;

import com.chatUcaldas.chat_ucaldas.entity.Question;

public interface QuestionService {
	
	public Question addQuestion(Question question);
	
	public List<Question> getAllQuestions();

}
