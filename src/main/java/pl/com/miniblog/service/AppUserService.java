package pl.com.miniblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.miniblog.appUser.AppUser;
import pl.com.miniblog.repository.AppUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public Long registerUser(String email, String password, String name) {
        if (!email.isEmpty() && !password.isEmpty()) {
            Optional<AppUser> userByEmail = appUserRepository.findByEmail(email);
            if (!userByEmail.isPresent()) {
                AppUser user = new AppUser();
                user.setEmail(email);
                user.setPassword(password);
                user.setName(name);
                AppUser savePerson = appUserRepository.save(user);
                return savePerson.getId();
            }


        }
        return -1L;
    }


    public List<AppUser> getUserList() {
        return appUserRepository.findAll();

    }


    public boolean editUser(Long id, String name, String surname, String description) {

        if (!name.isEmpty() && !surname.isEmpty() && !description.isEmpty()) {
            AppUser user = appUserRepository.findById(id).get();
            user.setName(name);
            user.setSurname(surname);
            user.setDescriptionAcount(description);

            appUserRepository.save(user);
            return true;
        }
        return false;
    }


//    public Optional<AppUser> editUser(Long id, EditAppUserDto dto) {
//
//        Optional<AppUser> searchedUser = appUserRepository.findById(id);
//
//        if (searchedUser.isPresent()) {
//
//            AppUser user = searchedUser.get();
//
//
//            user.setName(dto.getEdited_name());
//            user.setSurname(dto.getEdited_surname());
//            user.setDescriptionAcount(dto.getEdited_description());
//
//
//            if (dto.getEdited_surname() != null) {
//                user.setSurname(dto.getEdited_surname());
//            }
//            user = appUserRepository.save(user);
//
//
//            return Optional.of(user);
//        }
//
//        return Optional.empty();
//    }

    public Optional<AppUser> unregister(Long id) {

        if (id != null) {

            Optional<AppUser> searchedUser = appUserRepository.findById(id);
            if (searchedUser.isPresent()) {
                AppUser user = searchedUser.get();


                appUserRepository.delete(user);


                return Optional.of(user);
            }
        }
        return Optional.empty();
    }


    public AppUser getPersonByEmail(String email) {
        return appUserRepository.findByEmail(email).get();
    }

    public AppUser getPersonById(Long id){
        return appUserRepository.findById(id).get();
    }
}
