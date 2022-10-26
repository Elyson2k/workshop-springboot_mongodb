package com.devnc.workshop.service;

import com.devnc.workshop.dto.UserDTO;
import com.devnc.workshop.entities.User;
import com.devnc.workshop.repository.UserRepository;
import com.devnc.workshop.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findByID(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Error: ID não constado no sistema."));
    }

    public User insert(User user){
        user.setId(null);
        return userRepository.save(user);
    }

    public void deleteUserID(String id){
        userRepository.deleteById(id);
    }

    public User update(String id, UserDTO user) {
            User obj = findByID(id);
            updateData(obj, user);
            return userRepository.save(obj);
    }

    // =================================================================================================================

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
    }

    private void updateData(User newObj, UserDTO obj) {
        obj.setName(newObj.getName());
        obj.setEmail(newObj.getEmail());
    }

}
