package com.bit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.entity.ContactEntity;
import com.bit.model.Contact;
import com.bit.repository.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepository contactrepo;
	@Override
	public boolean saveContact(Contact c) {
		ContactEntity entity=new ContactEntity();
		BeanUtils.copyProperties(c, entity);
		ContactEntity saveEntity=contactrepo.save(entity);
		return saveEntity.getContactId()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {

		List<ContactEntity> entities=contactrepo.findAll();
		return entities.stream().map(entity -> {
			Contact contact=new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList()) ;

	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactEntity> findById=contactrepo.findById(cid);
		if(findById.isPresent()) {
			ContactEntity entity=findById.get();
			Contact contact=new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}
		return null;
	}

	@Override
	public boolean updateContact(Contact c) {
		return false;
	}

	@Override
	public boolean deleteContact(Integer cid) {
		contactrepo.deleteById(cid);
		return true;
	}

}
