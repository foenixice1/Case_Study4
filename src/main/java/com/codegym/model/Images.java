package com.codegym.model;

import javax.persistence.*;

@Entity
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imgAvt;
    private String imgPost;
    private String imgCover;

    public Images() {
    }

    public Images(Integer id, String imgAvt, String imgPost, String imgCover) {
        this.id = id;
        this.imgAvt = imgAvt;
        this.imgPost = imgPost;
        this.imgCover = imgCover;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgAvt() {
        return imgAvt;
    }

    public void setImgAvt(String imgAvt) {
        this.imgAvt = imgAvt;
    }

    public String getImgPost() {
        return imgPost;
    }

    public void setImgPost(String imgPost) {
        this.imgPost = imgPost;
    }

    public String getImgCover() {
        return imgCover;
    }

    public void setImgCover(String imgCover) {
        this.imgCover = imgCover;
    }
}
