package uth.edu.backend.entity.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import uth.edu.backend.entity.Role;
import uth.edu.backend.entity.User;
import uth.edu.backend.service.UserService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.findByUsername(username);
    if (user == null) {
        throw new UsernameNotFoundException("User not found");
    }

    Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
    Set<Role> roles = new HashSet<>();
    Role role1 = new Role();
    role1.setId(1L);
    role1.setName("USER");
    Role role2 = new Role();
    role2.setId(2L);
    role2.setName("ADMIN");
    Role role3 = new Role();
    role3.setId(3L);
    role3.setName("SELLER");
    roles.add(role1);
    roles.add(role2);
    roles.add(role3);

    for (Role userRole : roles) {
        grantedAuthoritySet.add(new SimpleGrantedAuthority(userRole.getName()));
    }

    return new CustomUserDetails(user, grantedAuthoritySet);
    }
}