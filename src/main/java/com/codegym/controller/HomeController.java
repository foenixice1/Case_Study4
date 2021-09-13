package com.codegym.controller;

import com.codegym.model.*;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private IPostService postService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IFriendService friendService;


    @ModelAttribute
    public ArrayList<Comment> listComment() {
        return (ArrayList<Comment>) commentService.findAll();
    }


    @ModelAttribute
    public ArrayList<Friend> listFri() {
        return (ArrayList<Friend>) friendService.findAll();
    }

    @ModelAttribute
    public ArrayList<Post> listPost() {
        return (ArrayList<Post>) postService.findAll();
    }

    @RequestMapping
    public ModelAndView home(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("index");
        User user = (User) authentication.getPrincipal();
        Accounts accounts = accountService.findAccountByUsername(user.getUsername());
        List<Post> listPost = (List<Post>) postService.findAll();
        modelAndView.addObject("Account", accounts);
        modelAndView.addObject("ListFriend", accountService.findAllAccountFriend(accounts.getId()));
        modelAndView.addObject("ListNotFriend", accountService.findAllAccountNotFriend(accounts.getId()));
        modelAndView.addObject("listPost", listPost);
        modelAndView.addObject("newPost", new Post());
        modelAndView.addObject("newCmt", new Comment());
        return modelAndView;
    }


//    @RequestMapping("/home")
//    public ModelAndView home() {
//        ModelAndView modelAndView = new ModelAndView("home");
//        List<Accounts> listAccount = (List<Accounts>) accountService.findAll();
//        List<Post> listPost = (List<Post>) postService.findAll();
//        List<Comment> listCmt = (List<Comment>) commentService.findAll();
//        modelAndView.addObject("list", listAccount);
//        modelAndView.addObject("listPost", listPost);
//        modelAndView.addObject("listCmt", listCmt);
//        return modelAndView;
//    }


    @PostMapping("/createPost")
    public ModelAndView createPost(@RequestParam MultipartFile uppImg, @ModelAttribute Post post, Authentication authentication) {
        String nameImg = uppImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File("D:\\Module4\\Case_Study4\\src\\main\\webapp\\WEB-INF\\views\\images\\fileUpload/" + nameImg));
            String urlImg = "/images/fileUpload/" + nameImg;
            post.setImg(urlImg);
        } catch (IOException e) {
            System.err.println("Chua upLoad file");
        }
        User user = (User) authentication.getPrincipal();
        Accounts accounts = accountService.findAccountByUsername(user.getUsername());
        post.setAccounts(accounts);
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        post.setDate(date);
        postService.save(post);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/createCmt")
    public ModelAndView createCmt(@RequestParam("idPost") int id,@ModelAttribute Comment comment, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Accounts accounts = accountService.findAccountByUsername(user.getUsername());
        Post post = postService.findById(id).get();
        comment.setPost(post);
        comment.setAccounts(accounts);
        commentService.save(comment);
        return new ModelAndView("redirect:/home");
    }


//    @GetMapping("/createPost")
//    public ModelAndView showCreate() {
//        ModelAndView modelAndView = new ModelAndView("createPost");
//        modelAndView.addObject("listPost", new Post());
//        return modelAndView;
//    }



//    @GetMapping("/createCmt")
//    public ModelAndView showCmt() {
//        ModelAndView modelAndView = new ModelAndView("createCmt");
//        modelAndView.addObject("listCmt", new Comment());
//        return modelAndView;
//    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        Post post = postService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("listPost", post);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@RequestParam MultipartFile uppImg, @ModelAttribute Post post) {
        String nameImg = uppImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File("D:\\Module4\\Case_Study4\\src\\main\\webapp\\WEB-INF\\views\\images\\fileUpload/" + nameImg));
            String urlImg = "/images/fileUpload/" + nameImg;
            post.setImg(urlImg);
        } catch (IOException e) {
            System.err.println("Chua upLoad file");
        }
        postService.save(post);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/editCmt/{id}")
    public ModelAndView showEditCmt(@PathVariable int id) {
        Comment comment = commentService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("editCmt");
        modelAndView.addObject("listCmt", comment);
        return modelAndView;
    }

    @PostMapping("/editCmt/{id}")
    public ModelAndView editCmt(@ModelAttribute Comment comment) {
        commentService.save(comment);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCmtPost(@PathVariable int id) {
        postService.delete(id);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/deleteCmt/{id}")
    public ModelAndView deleteCmt(@PathVariable int id) {
        commentService.delete(id);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName) {
        ModelAndView modelAndView = new ModelAndView("search-result");
        modelAndView.addObject("listPostFindAll", postService.findAllByConten(findName));
        modelAndView.addObject("Account", accountService.findAllByName(findName));
        return modelAndView;
    }

    @GetMapping("/about/{id}")
    public ModelAndView about(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("about");
        modelAndView.addObject("Account", accountService.findById(id).get());
        return modelAndView;
    }

    @GetMapping("/setting/{id}")
    public ModelAndView setting(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("setting");
        modelAndView.addObject("MyAccount", accountService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/setting")
    public ModelAndView createAccount(@ModelAttribute Accounts account) {
        Accounts accounts = accountService.findById(account.getId()).get();
        account.setRole(accounts.getRole());
        account.setUsername(accounts.getUsername());
        account.setPasswd(accounts.getPasswd());
        ModelAndView modelAndView = new ModelAndView("redirect:/home/setting/" + accounts.getId());
        accountService.save(account);
        return modelAndView;
    }
}
