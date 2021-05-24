package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.common.Contact;
import com.example.demo.mapper.contact_send.ContactMapper;

@Service
public class ContactService {

	@Autowired
	ContactMapper contactMapper;


//	問い合わせ追加
	public void save(Contact contact) {
		contactMapper.save(contact);
	}

}
