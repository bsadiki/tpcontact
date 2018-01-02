package com.sadiki.tpcontact;

import com.sadiki.tpcontact.entities.Contact;
import com.sadiki.tpcontact.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TpContactApplicationTests {
	@Autowired
	private ContactRepository contactRepository;
	@Test
	public void contextLoads() {
		DateFormat dateFormat=new SimpleDateFormat("dd/mm/yyyy");
		try {
			contactRepository.save(new Contact("SADIKI","Badr-Eddine",dateFormat.parse("11/11/1994"),"besadiki@gmail.com",648022566,"badr.png"));
			contactRepository.save(new Contact("ABCD","Efgh",dateFormat.parse("11/11/1994"),"ABCD@gmail.com",648022566,"Efgh.png"));
			contactRepository.save(new Contact("IJKL","Mnop",dateFormat.parse("11/11/1994"),"IJKL@gmail.com",648022566,"Mnop.png"));
			contactRepository.findAll().forEach(contact -> {
				System.out.println(contact.getNom());
			});
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
