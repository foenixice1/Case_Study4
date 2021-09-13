package com.codegym.service;

import com.codegym.model.Post;

import java.util.ArrayList;

public interface IPostService extends IGeneralService<Post> {
    ArrayList<Post> findAllByConten(String conten);

}
