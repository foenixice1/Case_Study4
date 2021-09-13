package com.codegym.service;

import com.codegym.model.Comment;

import java.util.List;

public interface ICommentService extends IGeneralService<Comment> {
    List<Comment> findByPost(int id);
}
