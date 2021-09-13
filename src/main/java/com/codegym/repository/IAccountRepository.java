package com.codegym.repository;

import com.codegym.model.Accounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;


public interface IAccountRepository extends CrudRepository<Accounts,Integer> {
    Accounts findAccountsByUsername(String username);
    Accounts findAccountsById(int id);
    ArrayList<Accounts> findAllByNameContaining(String name);
    @Query(value = "select * from accounts where id not in (select id from accounts where id in (select idFriend from accounts left join friend on accounts.id=friend.accounts_id where accounts_id=:id)) and id!=:id", nativeQuery = true)
    ArrayList<Accounts> findAllFriend(@Param("id") int idAccount);
    @Query(value = "select * from accounts where id not in (select id from accounts where id in (select idFriend from accounts left join friend on accounts.id=friend.accounts_id where accounts_id=:id))",nativeQuery = true)
    ArrayList<Accounts> findAccountNotFriend(@Param("id") int idAccount);

}
