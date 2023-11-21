package com.chatUcaldas.chat_ucaldas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chatUcaldas.chat_ucaldas.entity.InfoContactoPayment;
import com.chatUcaldas.chat_ucaldas.service.InfoContactPaymentServiceImpl;

@RestController
@RequestMapping("/chat-ucaldas")
@CrossOrigin(origins="*")
public class ChatControllerInfoContPayms {
	
	@Autowired
	@Qualifier("InfoContactPaymentServiceImpl")
	private InfoContactPaymentServiceImpl infoContactPaymService;
	
	//Info_contacto_payment ---------------------------------
	
	@PostMapping(path="/newInfoContactPayment", produces={"application/json"})
	@CrossOrigin(methods= { RequestMethod.POST })
	public ResponseEntity<?> newInfoContactPayment(@RequestBody InfoContactoPayment infoContactoPayment) throws Exception {
		try {
			return new ResponseEntity<InfoContactoPayment>(infoContactPaymService.addInfoContPayment(infoContactoPayment), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
