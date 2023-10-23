package com.chatUcaldas.chat_ucaldas.entity;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@Table(name="ROLE")
public class Role {
	
	@Id
	@Column(name = "ID_ROLE")
	@SequenceGenerator(name = "PQRS_SEQ_GENERATOR", sequenceName = "PQRS_SEQ_GENERATOR", allocationSize = 1)
	@GeneratedValue(generator = "PQRS_SEQ_GENERATOR", strategy = GenerationType.SEQUENCE)
	private long idRole;

	@Column(name = "ROLE")
	private String role;
	


}
