package com.sadiki.tpcontact.web;

import com.sadiki.tpcontact.entities.Contact;
import com.sadiki.tpcontact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ContactRestService {
    @Autowired
    private ContactRepository contactRepository;
    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    private List<Contact> getContacts(){
        return contactRepository.findAll();
    }
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
    private Contact getContact(@PathVariable Long id){
        return contactRepository.findOne(id);
    }
    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    private Contact save(@RequestBody Contact contact){
        return contactRepository.save(contact);
    }
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
    private boolean delete(@PathVariable Long id){
        contactRepository.delete(id);
        return true;
    }
    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.PUT)
    private Contact update(@PathVariable Long id,@RequestBody Contact contact){
        contact.setId(id);
        return contactRepository.save(contact);
    }
    @RequestMapping(value = "/contactsByName", method = RequestMethod.GET)
    private Page<Contact> getContactsByName(@RequestParam(defaultValue = "") String nom,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "5") int size){
        return contactRepository.findByNomContains(nom, new PageRequest(page,size));
    }
}
