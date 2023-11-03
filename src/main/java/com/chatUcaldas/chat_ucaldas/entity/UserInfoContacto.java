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
@Table(name="USER_INFO_CONTACTO")
public class UserInfoContacto {
	
	@Id
	@Column(name = "ID_USER_INFO_CONTACTO")
	@SequenceGenerator(name = "USER_INFO_CONTACTO_GEN", sequenceName = "USER_INFO_CONTACTO_GEN", allocationSize = 1)
	@GeneratedValue(generator = "USER_INFO_CONTACTO_GEN", strategy = GenerationType.SEQUENCE)
	private long idUserInfoCont;
	
	@OneToOne
	@JoinColumn(name="ID_INFO_CONTACTO")
	private InfoContactoPayment infoContactoPayment;
	
	@OneToOne
	@JoinColumn(name="ID_USER")
	private UserChat userChat;
	
	

}
