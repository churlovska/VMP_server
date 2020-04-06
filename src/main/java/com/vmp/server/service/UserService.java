package com.vmp.server.service;

import com.vmp.server.entities.VMPUserDetails;
import com.vmp.server.entities.VMPUserEntity;
import com.vmp.server.repositories.VMPUserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    VMPUserRep vmpUserRep;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<VMPUserEntity> user = vmpUserRep.findByLogin(login);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + login));

        return user.map(VMPUserDetails::new).get();
    }
}
 /*   @PersistenceContext
    private EntityManager em;
    @Autowired
    VMPUserRep userRepository;
    @Autowired
    RoleRep roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        VMPUserEntity user = userRepository.findByLogin(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public boolean saveUser(VMPUserEntity user) {
        VMPUserEntity userFromDB = userRepository.findByLogin(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new RoleEntity(1L, "ROLE_USER")));
        user.setPassword(user.getPassword());
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Integer userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<VMPUserEntity> usergtList(Integer userId) {
        return em.createQuery("SELECT u FROM vmp_user u WHERE u.id > :paramId", VMPUserEntity.class)
                .setParameter("paramId", userId).getResultList();
    }


    public List<VMPUserEntity> allUsers() {
        return userRepository.findAll();
    }*/

