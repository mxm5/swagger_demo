package com.example.swagger_demo.controller;

import com.example.swagger_demo.domain.Contact;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/f")
public class ContactResource {

    ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap<>();

    @GetMapping("/{id} ")
    public Contact getcontact(@PathVariable String id) {

        System.out.println(id);
        Contact contact = contacts.get(id);
        System.out.println(contact);
        return contact;
    }


// {
//    "id": "1",
//    "address": "1",
//    "phone": "1",
//    "name": "1"
//  }
//  ,
//  {
//    "id": "2",
//    "address": "2",
//    "phone": "2",
//    "name": "2"
//  }
//  ,
//  {
//    "id": "4",
//    "address": "4",
//    "phone": "4",
//    "name": "4"
//  }


    @GetMapping("/*")
    public List<Contact> getAllContacts() {
        return new ArrayList<Contact>(contacts.values());
    }

    @PostMapping("/*")
    public Contact addContact(@RequestBody Contact contact) {
        return contacts.put(contact.getId(), contact);
    }

    @PostMapping("/l")
    public List<Contact> addContacts(@RequestBody List<Contact> contact) {

        Map<String, Contact> map = new HashMap<>();

        contact.forEach(c -> map.put(c.getId(), c));
        contacts.putAll(map);
        return (List<Contact>) contacts.values() ;
    }
}
