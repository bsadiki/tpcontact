package com.sadiki.tpcontact.repository;

import com.sadiki.tpcontact.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    public Page<Contact> findByNomContains(String nom, Pageable pageable);
}
