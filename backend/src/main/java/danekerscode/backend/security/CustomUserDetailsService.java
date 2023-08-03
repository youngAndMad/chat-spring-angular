package danekerscode.backend.security;

import danekerscode.backend.exception.InvalidCredentialsException;
import danekerscode.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var optional = userRepository.findByEmail(email);

        if (optional.isEmpty()){
            throw new InvalidCredentialsException();
        }

        return new CustomUserDetails(optional.get());
    }
}
