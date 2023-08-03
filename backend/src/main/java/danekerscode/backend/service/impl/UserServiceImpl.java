package danekerscode.backend.service.impl;

import danekerscode.backend.dto.TokenResponse;
import danekerscode.backend.dto.UserDTO;
import danekerscode.backend.enums.TokenType;
import danekerscode.backend.exception.EntityNotFoundException;
import danekerscode.backend.mapper.UserMapper;
import danekerscode.backend.model.User;
import danekerscode.backend.repository.UserRepository;
import danekerscode.backend.security.JwtUtil;
import danekerscode.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

import static danekerscode.backend.util.MapUtils.objectToMap;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;

    @Override
    public Map<String, Object> save(UserDTO dto) {
        var user = userRepository.save(userMapper.toModel(dto));
        var claimMap = objectToMap(user);
        var tokens = new TokenResponse(
                jwtUtil.generateToken(TokenType.ACCESS,claimMap , user.getEmail()),
                jwtUtil.generateToken(TokenType.REFRESH , claimMap , user.getEmail())
        );

        return Map.of("user" , user , "tokens" , tokens);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(User.class , id));
    }
}
