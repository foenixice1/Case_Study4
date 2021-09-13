package com.codegym.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String username;
    private String passwd;
    private String email;
    private String gender;
    private String about;
    private Date dateOfBirth;

    private String img;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Friend> friends;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Message> messages;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "accounts" , cascade = CascadeType.ALL)
    private Set<Post> posts;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "accounts" , cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @ManyToOne
    private Role role;

    public Accounts() {
    }

    public Accounts(int id, String name, String username, String passwd, String email, String gender, String about, Date dateOfBirth, String img, Set<Friend> friends, Set<Message> messages, Set<Post> posts, Set<Comment> comments, Role role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.passwd = passwd;
        this.email = email;
        this.gender = gender;
        this.about = about;
        this.dateOfBirth = dateOfBirth;
        this.img = img;
        this.friends = friends;
        this.messages = messages;
        this.posts = posts;
        this.comments = comments;
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Friend> getFriends() {
        return friends;
    }

    public void setFriends(Set<Friend> friends) {
        this.friends = friends;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
