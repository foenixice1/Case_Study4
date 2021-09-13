package com.codegym.service;


import com.codegym.model.Accounts;

import java.util.ArrayList;

public interface IAccountService extends IGeneralService<Accounts>{
    String createAndEditAccount(Accounts accounts);
    Accounts findAccountByUsername(String username);
    ArrayList<Accounts> findAllByName(String name);
    ArrayList<Accounts> findAllAccountFriend(int id);
    ArrayList<Accounts> findAllAccountNotFriend(int id);

}
