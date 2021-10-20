//package toy.playvip.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import toy.playvip.common.BaseException;
//import toy.playvip.common.Status;
//import toy.playvip.repository.UserRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class JwtUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository repository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        toy.playvip.entity.User user = repository.findByUsername(username).orElseThrow(
//                () -> new BaseException(Status.NO_EXISTS_INFO)
//        );
//
//        List<GrantedAuthority> roles = new ArrayList<>();
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//        if ((user.getAuthority()).equals("ROLE_ADMIN")) {
//            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        } else {
//            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }
//        return new User(user.getUsername(), user.getPassword(), roles);
//    }
//
//}