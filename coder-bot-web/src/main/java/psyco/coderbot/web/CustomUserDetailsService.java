package psyco.coderbot.web;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import psyco.user.center.client.service.UserService;

import javax.annotation.Resource;

/**
 * Created by peng on 15/10/17.
 */
public class CustomUserDetailsService implements UserDetailsService {
    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
