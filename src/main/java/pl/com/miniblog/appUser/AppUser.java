package pl.com.miniblog.appUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.com.miniblog.postUser.PostUser;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String email;
    private String password;


    private String name;
    private String surname;
    private String descriptionAcount;
    private LocalDate dateOfCreateAcount;
    private AccountStatus accountStatus;
    private TypeOfAccount typeOfAccount;

    public List<PostUser> getPostUsers() {
        return postUsers;
    }

    public void setPostUsers(List<PostUser> postUsers) {
        this.postUsers = postUsers;
    }

    @OneToMany
    @JoinColumn(name = "user_posts")
    private List<PostUser>postUsers;

    public AppUser() {
    }

    public AppUser(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDescriptionAcount() {
        return descriptionAcount;
    }

    public void setDescriptionAcount(String descriptionAcount) {
        this.descriptionAcount = descriptionAcount;
    }

    public LocalDate getDateOfCreateAcount() {
        return dateOfCreateAcount;
    }

    public void setDateOfCreateAcount(LocalDate dateOfCreateAcount) {
        this.dateOfCreateAcount = dateOfCreateAcount;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public TypeOfAccount getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(TypeOfAccount typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }
}
