package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.model.Role;
import web.model.User;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserServiceInterface userService;

    @Autowired
    public UserDetailsServiceImpl(UserServiceInterface userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        return fromUser(user);
    }

    private UserDetails fromUser(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                user.getRoles()
        );
    }

//    public Set<SimpleGrantedAuthority> getAuthorities(User user) {
//        return user.getRoles().stream()
//                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
//                .collect(Collectors.toSet());
//    }
}
