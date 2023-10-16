package com.chatUcaldas.chat_ucaldas.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="USER_CHAT")
public class UserChat {
	
	@Id
	@Column(name = "ID_USER")
	@SequenceGenerator(name = "USER_SEQ_GENERATOR", sequenceName = "USER_SEQ_GENERATOR", allocationSize = 1)
	@GeneratedValue(generator = "USER_SEQ_GENERATOR", strategy = GenerationType.SEQUENCE)
	private long idUser;
	
	@Column(name = "USER_CHAT")
	private String userChat;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "EMAIL")
	private String email;

	@OneToOne
	@JoinColumn(name="ID_ROLE")
	private Role role;
	
}
