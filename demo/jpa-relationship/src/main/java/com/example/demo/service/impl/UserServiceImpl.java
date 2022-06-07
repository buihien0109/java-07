package com.example.demo.service.impl;

import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.CreateAddressReq;
import com.example.demo.request.CreateUserReq;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void addAddressToUser(String name, String city) {
        User user = userRepository.findByName(name);
        Address address = addressRepository.findByCity(city);

        user.setAddress(address);
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User createUser(CreateUserReq req) {
        User user = new User(null, req.getName(), req.getEmail(), req.getPassword(), null);
        return userRepository.save(user);
    }

    @Override
    public Address createAddress(CreateAddressReq req) {
        Address address = new Address(null, req.getCity());
        return addressRepository.save(address);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddress(Long id) {
        return addressRepository.findById(id).get();
    }
}
