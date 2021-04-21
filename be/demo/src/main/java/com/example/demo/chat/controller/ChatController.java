package com.example.demo.chat.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.chat.domain.Chat;
import com.example.demo.chat.service.ChatServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RestController
@RequiredArgsConstructor
@RequestMapping("chats")
@CrossOrigin("*")
public class ChatController {

    private final ChatServiceImpl service;

   @PostMapping("")
   public ResponseEntity<Void> register(
       @Validated @RequestBody Chat entity) {

        log.info("POST register()");

        service.save(entity);

        return new ResponseEntity<>(HttpStatus.OK);
   }

    @GetMapping("")
    public ResponseEntity<List<Chat>> list() {
         
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Chat>> read(@PathVariable long id) {

        
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable long id
                                        ,@RequestBody Chat entity) {
            log.info("-----------------------------------------");
        service.updateById(id, entity);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }


     
}
