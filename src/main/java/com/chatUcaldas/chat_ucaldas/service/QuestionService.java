package com.chatUcaldas.chat_ucaldas.service;

import java.util.List;

import com.chatUcaldas.chat_ucaldas.entity.Question;

public interface QuestionService {
	
	public abstract Question addQuestion(Question question);
	
	public abstract List<Question> getAllQuestions();

}
