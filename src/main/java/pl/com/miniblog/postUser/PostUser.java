package pl.com.miniblog.postUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.com.miniblog.appUser.AppUser;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
public class PostUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String title;
    private String text;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private PostStatus postStatus;

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    @ManyToOne
    private AppUser user;


    public PostUser() {
    }

    public PostUser(String title, String text, LocalDateTime localDateTime) {
        this.title = title;
        this.text = text;
        this.localDateTime = localDateTime;
    }
}
