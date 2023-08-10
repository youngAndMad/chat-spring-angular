package danekerscode.backend.service.impl;

import danekerscode.backend.dto.AuthRequest;
import danekerscode.backend.dto.TokenResponse;
import danekerscode.backend.dto.UserDTO;
import danekerscode.backend.enums.TokenType;
import danekerscode.backend.exception.EntityNotFoundException;
import danekerscode.backend.mapper.UserMapper;
import danekerscode.backend.model.User;
import danekerscode.backend.repository.UserRepository;
import danekerscode.backend.security.CustomUserDetailsService;
import danekerscode.backend.security.JwtUtil;
import danekerscode.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

import static danekerscode.backend.enums.TokenType.ACCESS;
import static danekerscode.backend.enums.TokenType.REFRESH;
import static danekerscode.backend.util.MapUtils.toClaims;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager manager;
    private final CustomUserDetailsService userDetailsService;

    @Override
    public Map<String, Object> save(UserDTO dto) {
        var model = userMapper.toModel(dto);
        model.setPassword(passwordEncoder.encode(dto.password()));
        var user = userRepository.save(model);
        return Map.of("user", user, "tokens", tokenResponse(user));
    }

    @Override
    public Map<String, Object> refresh(String refreshToken) {
        var email = jwtUtil.extractUsername(refreshToken , REFRESH);
        var user = userDetailsService.loadUserByUsername(email);
        return Map.of("tokens" ,tokenResponse((User) user));
    }

    @Override
    public Map<String, Object> auth(AuthRequest authRequest) {
        UsernamePasswordAuthenticationToken ur = new
                UsernamePasswordAuthenticationToken(authRequest.email(), authRequest.password());
        var user = (User) manager.authenticate(ur).getPrincipal();
        return Map.of("tokens", tokenResponse(user));
    }

    private TokenResponse tokenResponse(User user) {
        return new TokenResponse(
                jwtUtil.generateToken(ACCESS, toClaims(user, ACCESS), user.getEmail()),
                jwtUtil.generateToken(REFRESH, toClaims(user, REFRESH), user.getEmail())
        );
    }

}
