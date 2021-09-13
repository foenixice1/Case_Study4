package com.codegym.repository;

import com.codegym.model.Friend;
import org.springframework.data.repository.CrudRepository;

public interface IFriendRepo extends CrudRepository<Friend,Integer> {
}
