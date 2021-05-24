package com.example.demo.mapper.contact_send;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.common.Contact;



@Mapper
public interface ContactMapper {


//	問い合わせ追加
	void save(Contact contact);

}
