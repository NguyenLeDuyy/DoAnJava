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
import uth.edu.backend.entity.UserRole;
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
        Set<UserRole> roles = user.getUserRoles();

        for (UserRole userRole : roles) {
            grantedAuthoritySet.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
        }

        return new CustomUserDetails(user, grantedAuthoritySet);
    }
}
