package com.codegym.service.Impl;

import com.codegym.model.Post;
import com.codegym.repository.IPostRepo;
import com.codegym.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PostImpl implements IPostService {
    @Autowired
    IPostRepo iPostRepo;

    @Override
    public Iterable<Post> findAll() {
        return iPostRepo.findAll();
    }

    @Override
    public Optional<Post> findById(Integer id) {
        return iPostRepo.findById(id);
    }

    @Override
    public void save(Post post) {
        iPostRepo.save(post);

    }

    @Override
    public void delete(Integer id) {
        iPostRepo.deletePost(id);
    }

    @Override
    public ArrayList<Post> findAllByConten(String conten) {
        return iPostRepo.findAllByContenPostContaining(conten);
    }

}
