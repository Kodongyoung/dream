package com.example.demo.chat.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.chat.domain.Chat;
import com.example.demo.chat.repository.ChatRepository;
import com.example.demo.cmm.service.AbstractService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
@Service
public class ChatServiceImpl extends AbstractService<Chat> implements ChatService {
    private final ChatRepository repo;

    @Override
    public long count() {
        
        return 0;
    }

    @Override
    public boolean existsById(long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Chat> findAll() {
        // TODO Auto-generated method stub
        log.info("before findall");

        List<Chat> userList = repo.findAll();

        log.info("after findall");
        return userList;
    }

    @Override
    public void deleteById(long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Chat getOne(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Chat entity) {
        repo.save(entity);
        
    }

    @Override
    public Optional<Chat> findById(long id) {
        // TODO Auto-generated method stub
        return repo.findById(id);
    }

    @Override
    public Long updateById(long id, Chat entity) {
        // TODO Auto-generated method stub
        log.info("id:   " + id);
        Chat chat = repo.findById(id).orElseThrow();

        log.info("boardno------------" + chat.getBoardNo());
        Chat updateChat = chat.builder()
            .boardNo(id)
            .regdate(entity.getRegdate())
            .message(entity.getMessage())
            .keyboard(entity.getKeyboard())
            .build();

            log.info("boardno" + updateChat.getBoardNo());
           repo.save(updateChat);


        return null;
    }

    

 
}