package com.codegym.service.Impl;

import com.codegym.model.Friend;
import com.codegym.service.IFriendService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FriendImpl implements IFriendService {
    @Override
    public Iterable<Friend> findAll() {
        return null;
    }

    @Override
    public Optional<Friend> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Friend friend) {

    }

    @Override
    public void delete(Integer id) {

    }
}
