package com.vmp.server.service;

import com.vmp.server.entities.VMPUserDetails;
import com.vmp.server.entities.VMPUserEntity;
import com.vmp.server.repositories.VMPUserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    VMPUserRep vmpUserRep;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        VMPUserEntity user = vmpUserRep.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + login));
        return VMPUserDetails.build(user);
    }


}



