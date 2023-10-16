package com.chatUcaldas.chat_ucaldas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="USER_INFO_CONTACTO")
public class UserInfoContacto {
	
	@Column(name = "ID_USER_INFO_CONTACTO")
	private long idUserInfoCont;
	
	@Id
	@Column(name = "ID_INFO_CONTACTO")
	private long idInfoContacto;
	
	@Column(name = "ID_USER")
	private long idUser;
	
	

}
