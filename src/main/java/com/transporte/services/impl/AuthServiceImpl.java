package com.transporte.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transporte.dto.UserLogin;
import com.transporte.entities.User;
import com.transporte.models.ResponseService;
import com.transporte.repositories.UserRepository;
import com.transporte.services.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public ResponseService login(UserLogin userLogin) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword());
        authenticationManager.authenticate(authentication);
        UserDetails user = (UserDetails) userRepository.findOneByUsernameAndEstatus(userLogin.getUsername(), 1).get();
        //String jwt = jwtService.generateToken(user, generateExtraClaims((User) user));
        return null;
    }

    /*private Map<String, Object> generateExtraClaims(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getUsername());
        extraClaims.put("role", user.getRoles());
        extraClaims.put("authorities", user.getAuthorities());
        return extraClaims;
    }*/

}
