package com.chatUcaldas.chat_ucaldas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chatUcaldas.chat_ucaldas.entity.Question;
import com.chatUcaldas.chat_ucaldas.repository.RepoQuestion;

import jakarta.transaction.Transactional;

@Service("QuestionServiceImpl")
@Transactional
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	@Qualifier("QuestionRepository")
	RepoQuestion repositoryQuestion;

	@Override
	public Question addQuestion(Question question) {
		return repositoryQuestion.save(question);
	}

	@Override
	public List<Question> getAllQuestions() {
		return (List<Question>) repositoryQuestion.findAll();
	}

}
