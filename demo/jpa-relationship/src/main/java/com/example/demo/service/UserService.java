package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import com.example.demo.request.CreateAddressReq;
import com.example.demo.request.CreateUserReq;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Address saveAddress(Address address);
    void addAddressToUser(String name, String city);

    List<User> getUsers();
    User getUser(Long id);

    List<Address> getAllAddress();
    Address getAddress(Long id);

    User createUser(CreateUserReq req);
    Address createAddress(CreateAddressReq req);
    void deleteUser(Long id);
}
