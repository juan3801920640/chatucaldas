package com.chatUcaldas.chat_ucaldas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chatUcaldas.chat_ucaldas.entity.InfoContactoPayment;

@Repository("repoInfoContactoPaymentRepository")
public interface RepoInfoContactoPayment extends CrudRepository<InfoContactoPayment, Long>{

}
