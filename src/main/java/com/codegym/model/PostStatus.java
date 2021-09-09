package com.codegym.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class PostStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String contenPost;
    private Date date;

    @OneToMany
    private List<Images> images;
    @OneToMany
    private List<Comment> comments;

    private int like;

    public PostStatus() {
    }

    public PostStatus(Integer id, String contenPost, List<Images> images, Date date, List<Comment> comments, int like) {
        this.id = id;
        this.contenPost = contenPost;
        this.images = images;
        this.date = date;
        this.comments = comments;
        this.like = like;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenPost() {
        return contenPost;
    }

    public void setContenPost(String contenPost) {
        this.contenPost = contenPost;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
