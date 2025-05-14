package com.project.smartfamily.Controllers;

import com.project.smartfamily.Entities.User;
import com.project.smartfamily.dto.LoginRequest;
import com.project.smartfamily.dto.RegisterRequest;
import com.project.smartfamily.dto.UserDto;
import com.project.smartfamily.Repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {
        "http://localhost:3000",
        "https://apparently-effective-greenling.cloudpub.ru",
        "https://observantly-earnest-finfoot.cloudpub.ru"  // <-- ваш бекенд-домен
})
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Регистрация
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegisterRequest req) {
        // Проверяем, не занят ли email
        if (userRepository.findByEmail(req.getEmail()).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .build();
        }

        // Создаем и сохраняем пользователя
        User user = new User();
        user.setEmail(req.getEmail());
        user.setRole(req.getRole());
        user.setPasswordHash(
                passwordEncoder.encode(req.getPassword())
        );
        User saved = userRepository.save(user);

        // Возвращаем DTO без пароля
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toDto(saved));
    }

    // Вход
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequest req) {
        return userRepository.findByEmail(req.getEmail())
                .filter(u -> passwordEncoder.matches(
                        req.getPassword(),
                        u.getPasswordHash()
                ))
                .map(u -> ResponseEntity.ok(toDto(u)))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .build());
    }

    // Вспомогательный метод преобразования в DTO
    private UserDto toDto(User u) {
        UserDto dto = new UserDto();
        dto.setUserId(u.getUserId());
        dto.setEmail(u.getEmail());
        dto.setRole(u.getRole());
        // не включаем пароль!
        return dto;
    }
}
