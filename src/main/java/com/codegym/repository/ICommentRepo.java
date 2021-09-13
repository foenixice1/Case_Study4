package com.codegym.repository;

import com.codegym.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICommentRepo extends CrudRepository<Comment,Integer> {
    List<Comment> findCommentByPost(int id);
}
