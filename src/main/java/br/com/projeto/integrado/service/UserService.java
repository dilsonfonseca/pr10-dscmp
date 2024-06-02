package br.com.projeto.integrado.service;


import br.com.projeto.integrado.entity.User;
import br.com.projeto.integrado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null) ;
    }

    // Busca de usuário por email
    public User findByEmail(String email){
        return userRepository.findByUserEmail(email).get();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Integer id, User user) {
        User userAtualizado = userRepository.findById(id).orElse(null);
        if(userAtualizado != null) {
            userAtualizado.setUserEmail(user.getUserEmail());
            //userAtualizado.setUserPassword(user.getUserPassword());
            userAtualizado.setUsuarioNome(user.getUsuarioNome());
            return userRepository.save(userAtualizado);
        }else {
            return null;
        }
    }

    public Boolean deleteUser(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null) {
            userRepository.delete(user);
            return true;
        }else {
            return false;
        }
    }
}