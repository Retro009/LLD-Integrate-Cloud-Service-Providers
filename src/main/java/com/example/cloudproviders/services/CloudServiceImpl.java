package com.example.cloudproviders.services;

import com.example.cloudproviders.adapters.CloudAdapter;
import com.example.cloudproviders.exceptions.UserNotFoundException;
import com.example.cloudproviders.models.Connection;
import com.example.cloudproviders.models.User;
import com.example.cloudproviders.repositories.UserRepository;

public class CloudServiceImpl implements CloudService{
    private CloudAdapter cloudAdapter;
    private UserRepository userRepository;
    public CloudServiceImpl(CloudAdapter cloudAdapter, UserRepository userRepository){
        this.cloudAdapter = cloudAdapter;
        this.userRepository = userRepository;
    }
    @Override
    public Connection createConnection(Long userId) throws UserNotFoundException {
        User user = userRepository.findUserById(userId).orElseThrow(()->new UserNotFoundException("User Not Found"));
        return cloudAdapter.createConnection(user.getId());
    }
}
