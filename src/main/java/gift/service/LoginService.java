package gift.service;

import gift.Dto.User;
import gift.Jwt.JwtUtil;
import gift.repository.JdbcUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    private final JdbcUserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Autowired
    public LoginService(JdbcUserRepository repository , JwtUtil jwtUtil) {
        this.userRepository = repository;
        this.jwtUtil = jwtUtil;
    }

    public boolean saveUser(User user) {
        if(userRepository.save(user).isEmpty()){ //저장하지 못했다면
            return false;
        }
        return true;
    }

    public boolean login(User user) {
        if(userRepository.isExistUser(user).isEmpty()) {
            return false;
        }
        return true;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
