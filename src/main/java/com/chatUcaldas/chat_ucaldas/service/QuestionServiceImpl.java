package com.chatUcaldas.chat_ucaldas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chatUcaldas.chat_ucaldas.entity.Question;
import com.chatUcaldas.chat_ucaldas.repository.RepoQuestion;

import jakarta.transaction.Transactional;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("QuestionServiceImpl")
@Transactional
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	@Qualifier("QuestionRepository")
	RepoQuestion repositoryQuestion;
	
	private final RestTemplate restTemp = new RestTemplate();
	private final String url = "http://127.0.0.1:8000/chat";
	private String response = "";

	@Override
	public Question addQuestion(Question question) {
		
		String jsonRequest = "{\"query\": \"" + question.getQuestion() + "\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequest, headers);
		response = restTemp.postForObject(url, requestEntity, String.class);
		
		
		question.setAnswer(extraerAnswerDesdeJson(response));
		
		return repositoryQuestion.save(question);
	}

	@Override
	public List<Question> getAllQuestions() {
		return (List<Question>) repositoryQuestion.findAll();
	}
	
	
	private String extraerAnswerDesdeJson(String jsonResponse) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);
            JsonNode dataNode = jsonNode.path("data");

            if (dataNode.isMissingNode() || dataNode.path("content").isMissingNode()) {
                return "Campos 'data' o 'content' no encontrados en la respuesta JSON";
            }

            return dataNode.path("content").asText();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al procesar la respuesta JSON";
        }
	}

}
