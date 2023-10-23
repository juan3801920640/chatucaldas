package com.chatUcaldas.chat_ucaldas.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="CHAT")
public class Chat {
	
	@Id
	@Column(name = "ID_CHAT")
	@SequenceGenerator(name = "CHAT_SEQ_GENERATOR", sequenceName = "CHAT_SEQ_GENERATOR", allocationSize = 1)
	@GeneratedValue(generator = "CHAT_SEQ_GENERATOR", strategy = GenerationType.SEQUENCE)
	private long idChat;
	
	@Column(name = "TITLE")
	private String title;
	
	@OneToOne
	@JoinColumn(name="ID_USER")
	private UserChat userChat;
	
	@Column(name = "DATE_CHAT")
	private Date dateChat = new Date();
	
	@OneToMany(mappedBy = "chat", orphanRemoval = true, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Question> questions;

}
