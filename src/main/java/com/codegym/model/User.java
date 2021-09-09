package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Pattern(regexp = "^[^\\d]+$", message = "Name only letters can't enter numbers")
    String name;

    @NotEmpty
    String birthday;

    @NotEmpty
    String address;

    @NotEmpty
    @Pattern(regexp = "^[0]\\d{9}$", message = "Phone numbers must start at 0 and follow 9 numbers. Can't be a letter")
    String phone;


    @OneToMany
    private List<Images> images;

    @OneToMany
    private List<Friend> friends;

    @OneToMany
    private List<Message> messages;

    @OneToMany
    private List<PostStatus> posts;

    public User() {
    }

    public User(Integer id, String name, String birthday, String address, String phone, List<Images> images, List<Friend> friends, List<Message> messages, List<PostStatus> posts) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.images = images;
        this.friends = friends;
        this.messages = messages;
        this.posts = posts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<PostStatus> getPosts() {
        return posts;
    }

    public void setPosts(List<PostStatus> posts) {
        this.posts = posts;
    }
}
