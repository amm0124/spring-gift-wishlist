package gift.repository;

import gift.Dto.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> save(User user);
    Boolean isExistEmail(String email);
    List<User> findAll();
}
