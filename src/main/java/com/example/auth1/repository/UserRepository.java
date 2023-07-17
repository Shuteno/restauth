package com.example.auth1.repository;

import org.springframework.stereotype.Repository;
import com.example.auth1.model.Authorities;

import java.util.*;

@Repository
public class UserRepository {
    public Map<String, String> credentials = new HashMap<>();
    public Map<String, List<Authorities>> authorities = new HashMap<>();

    public List<Authorities> getUserAuthorities(String user, String password) {

        String tUsername = "user";
        String tPassword = "pass";
        List<Authorities> tAuthorities = List.of(Authorities.READ, Authorities.WRITE);
        credentials.put(tUsername, tPassword);
        authorities.put(tUsername, tAuthorities);

        if (credentials.containsKey(user) && credentials.get(user).equals(password)) {
            return authorities.get(user);
        }
        return Collections.emptyList();
    }
}