package com.codegym.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String contenPost;
    private Date date;
     private String img;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "post" , cascade = CascadeType.ALL)
    private List<Comment> comments;

    @ManyToOne
    private Accounts accounts;

    private int love;

    public Post() {
    }

    public Post(int id, String contenPost, Date date, String img, List<Comment> comments, Accounts accounts, int love) {
        this.id = id;
        this.contenPost = contenPost;
        this.date = date;
        this.img = img;
        this.comments = comments;
        this.accounts = accounts;
        this.love = love;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenPost() {
        return contenPost;
    }

    public void setContenPost(String contenPost) {
        this.contenPost = contenPost;
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

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

}
