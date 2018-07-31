package pl.com.miniblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.miniblog.postUser.PostUser;

public interface PostUserRepository extends JpaRepository<PostUser, Long> {
}
