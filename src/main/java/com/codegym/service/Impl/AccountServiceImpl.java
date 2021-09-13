package com.codegym.service.Impl;


import com.codegym.model.Accounts;
import com.codegym.repository.IAccountRepository;
import com.codegym.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService, UserDetailsService {
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public String createAndEditAccount(Accounts accounts) {
        if (accountRepository.findAccountsById(accounts.getId()) == null) {
            accountRepository.save(accounts);
            return "Create Success!";
        } else {
            accountRepository.save(accounts);
            return "Edit Success!";
        }
    }

    @Override
    public Accounts findAccountByUsername(String username) {
        return accountRepository.findAccountsByUsername(username);
    }


    @Override
    public ArrayList<Accounts> findAllByName(String name) {
        return accountRepository.findAllByNameContaining(name);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Accounts accounts = accountRepository.findAccountsByUsername(username);
        List<GrantedAuthority> ListAuth = new ArrayList<>();
        ListAuth.add(accounts.getRole());
        UserDetails userDetails = new User(accounts.getUserName(), accounts.getPasswd(), ListAuth);
        return userDetails;
    }

    @Override
    public Iterable<Accounts> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Accounts> findById(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public void save(Accounts accounts) {
        accountRepository.save(accounts);

    }

    @Override
    public void delete(Integer id) {
        accountRepository.deleteById(id);
    }
    @Override
    public ArrayList<Accounts> findAllAccountFriend(int id) {
        return accountRepository.findAllFriend(id);
    }

    @Override
    public ArrayList<Accounts> findAllAccountNotFriend(int id) {
        return accountRepository.findAccountNotFriend(id);
    }

}
