package com.example.finalproject.service;

import com.example.finalproject.model.Comment;
import com.example.finalproject.repository.CommentRepository;
import com.example.finalproject.service.core.AbstractCRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CommentService extends AbstractCRUD<Comment,Integer> {

    private final CommentRepository commentRepository;
    @PostConstruct
    public void init(){
        setJpaRepository(commentRepository);
    }
}
