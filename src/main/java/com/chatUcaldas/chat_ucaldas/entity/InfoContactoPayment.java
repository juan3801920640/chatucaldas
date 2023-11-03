package com.chatUcaldas.chat_ucaldas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="INFO_CONTACTO_PAYMENT")
public class InfoContactoPayment {
	
	@Id
	@Column(name = "ID_INFO_CONTACTO")
	@SequenceGenerator(name = "INFO_CONTACTO_PAYMENT_GEN", sequenceName = "INFO_CONTACTO_PAYMENT_GEN", allocationSize = 1)
	@GeneratedValue(generator = "INFO_CONTACTO_PAYMENT_GEN", strategy = GenerationType.SEQUENCE)
	private long idInfoContacto;
	
	@Column(name = "NUMERO_TARJETA")
	private String numeroTarjeta;
	
	@Column(name = "VENCIMIENTO")
	private String vencimiento;
	
	@Column(name = "CONTACTO")
	private String contacto;

}
