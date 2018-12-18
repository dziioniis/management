package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<User> getUsers() {
        return userRepository.findByRole(2, 3, 4);
    }

    @Override
    public void setRefreshToken(String refreshToken) {
        Claims body = Jwts.parser()
                .setSigningKey("youtube")
                .parseClaimsJws(refreshToken)
                .getBody();
        Object id = body.get("id");
        userRepository.refreshToken((long) (int) id, refreshToken);
    }

    @Override
    public User loadUserByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public User updateUser(User user) {
        if (user.getEmail() != null) {
            userRepository.updateMail(user.getId(), user.getEmail());
        }
        if (user.getPassword() != null) {
            userRepository.updatePassword(user.getId(), user.getPassword());
        }
        return userRepository.findByUsername(user.getUsername());
    }
}
