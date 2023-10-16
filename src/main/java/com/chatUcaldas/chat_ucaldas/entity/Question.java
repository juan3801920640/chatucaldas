package com.chatUcaldas.chat_ucaldas.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="QUESTION")
public class Question {
	
	@Id
	@Column(name = "ID_QUESTION")
	@SequenceGenerator(name = "QUESTION_SEQ_GENERATOR", sequenceName = "QUESTION_SEQ_GENERATOR", allocationSize = 1)
	@GeneratedValue(generator = "QUESTION_SEQ_GENERATOR", strategy = GenerationType.SEQUENCE)
	private long idQuestion;
	
	@Column(name = "QUESTION")
	private String question;
	
	@Column(name = "ANSWER")
	private String answer;
	
	@Column(name = "DATE_QUESTION")
	private Date dateQuestion = new Date();
	
	@ManyToOne
	@JoinColumn(name="ID_CHAT")
	@JsonBackReference
	private Chat chat;

}
