package com.codegym.service.Impl;

import com.codegym.model.Comment;
import com.codegym.repository.ICommentRepo;
import com.codegym.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentImpl implements ICommentService {
    @Autowired
    ICommentRepo iCommentRepo;

    @Override
    public Iterable<Comment> findAll() {
        return iCommentRepo.findAll();
    }

    @Override
    public Optional<Comment> findById(Integer id) {
        return iCommentRepo.findById(id);
    }

    @Override
    public void save(Comment comment) {
        iCommentRepo.save(comment);

    }

    @Override
    public void delete(Integer id) {
        iCommentRepo.deleteById(id);
    }

    @Override
    public List<Comment> findByPost(int id) {
        return iCommentRepo.findCommentByPost(id);
    }
}
