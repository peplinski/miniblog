package pl.com.miniblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.miniblog.appUser.AppUser;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    int countByEmail(String email);

    Optional<AppUser> findByEmail(String email);
}
