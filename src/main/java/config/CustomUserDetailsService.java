package config;

import org.hibernate.annotations.BatchSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CoT on 11/18/17.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {


    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new GrantedAuthority() {
            public String getAuthority() {
                return "ROLE_ADMIN";
            }
        };
        list.add(grantedAuthority);

        User user = new User("admin", "admin", true, true, true, true, list );


        return user;

    }
}
