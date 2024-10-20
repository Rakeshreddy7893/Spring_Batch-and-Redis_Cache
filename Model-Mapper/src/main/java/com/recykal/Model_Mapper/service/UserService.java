package com.recykal.Model_Mapper.service;

import com.recykal.Model_Mapper.dto.UserDTO;
import com.recykal.Model_Mapper.entity.User;
import com.recykal.Model_Mapper.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    public User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public UserDTO convertToDTO(User user) {
        userRepo.save(user);
        return modelMapper.map(user, UserDTO.class);
    }
}
