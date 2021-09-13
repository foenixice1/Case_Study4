package com.codegym.repository;

import com.codegym.model.Comment;
import com.codegym.model.Friend;
import com.codegym.model.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

public interface IPostRepo extends CrudRepository<Post,Integer> {
    ArrayList<Post> findAllByContenPostContaining(String conten);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM `case_study`.`post` WHERE (`id` =:id)" , nativeQuery = true)
    void deletePost(@Param("id") int id);
}
