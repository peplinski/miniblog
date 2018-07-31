package pl.com.miniblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.miniblog.postUser.PostUser;
import pl.com.miniblog.repository.PostUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostUserService {

    @Autowired
    private PostUserRepository postUserRepository;

    public Optional<PostUser> addPost(PostUser postUser) {
        postUser.getTitle();
        postUser.getText();

        postUser = postUserRepository.save(postUser);

        return Optional.of(postUser);
    }

    public List<PostUser> getPostList() {
        return postUserRepository.findAll();


    }


    public boolean editPost(Long id, String title, String text) {


        if (!title.isEmpty()&&text.isEmpty()) {
            PostUser post = postUserRepository.findById(id).get();
            post.setTitle(title);
            post.setText(text);



            postUserRepository.save(post);
            return true;
        }
        return false;
    }

    public Optional<PostUser> deletePost(Long id) {

        if (id != null) {
            Optional<PostUser> searchPost = postUserRepository.findById(id);
            if (searchPost.isPresent()) {
                PostUser post = searchPost.get();

                postUserRepository.delete(post);

                return Optional.of(post);
            }
        }
        return Optional.empty();
    }
}

