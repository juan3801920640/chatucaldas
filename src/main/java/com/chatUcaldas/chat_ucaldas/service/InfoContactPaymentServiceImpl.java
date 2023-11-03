package com.chatUcaldas.chat_ucaldas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chatUcaldas.chat_ucaldas.entity.InfoContactoPayment;
import com.chatUcaldas.chat_ucaldas.repository.RepoInfoContactoPayment;

import jakarta.transaction.Transactional;

@Service("InfoContactPaymentServiceImpl")
@Transactional
public class InfoContactPaymentServiceImpl implements InfoContactPaymentService{
	
	@Autowired
	@Qualifier("repoInfoContactoPaymentRepository")
	RepoInfoContactoPayment repositoryInfoContPay;
	

	@Override
	public InfoContactoPayment addInfoContPayment(InfoContactoPayment infoContactoPayment) {
		
		return repositoryInfoContPay.save(infoContactoPayment);
	}

}
