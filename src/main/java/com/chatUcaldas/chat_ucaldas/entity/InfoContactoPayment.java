package com.chatUcaldas.chat_ucaldas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="INFO_CONTACTO_PAYMENT")
public class InfoContactoPayment {
	
	@Id
	@Column(name = "ID_INFO_CONTACTO")
	private long idInfoContacto;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "NUMERO_TARJETA")
	private String numeroTarjeta;
	
	@Column(name = "VENCIMIENTO")
	private String vencimiento;
	
	@Column(name = "CONTACTO")
	private String contacto;

}
