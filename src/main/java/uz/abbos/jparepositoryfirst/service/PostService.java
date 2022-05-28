package uz.abbos.jparepositoryfirst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.abbos.jparepositoryfirst.Enum.PostTypes;
import uz.abbos.jparepositoryfirst.entity.Post;
import uz.abbos.jparepositoryfirst.exception.BadRequestException;
import uz.abbos.jparepositoryfirst.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;



    public Post getPost(Integer id) {
            Optional<Post> optional = postRepository.findById(id);
            postRepository.increamentViews(id);


        if (optional.isEmpty()) {
            throw new BadRequestException("Post not found");
        }
        return optional.get();

    }

    public Post createPost(Post post) {
        userService.check(post.getUserID());
        post.setToken(UUID.randomUUID().toString());
        post.setCreatedAt(LocalDateTime.now());
        post.setPostStatus(PostTypes.CREATED);
        post.setStatus(true);
        postRepository.save(post);
        return post;
    }

    public Post updatePost(Integer id, Post post) {
        Post p = getPost(id);
        p.setCategory(post.getCategory());
        p.setContent(post.getContent());
        p.setCategoryID(post.getCategoryID());
        p.setRegioID(post.getRegioID());
        p.setTitle(post.getTitle());
        p.setToken(post.getToken());
        postRepository.save(p);
        return p;

    }

    public boolean deletePost(Integer id) {
        Post post = getPost(id);
        postRepository.delete(post);
        return true;
    }

    public List<Post> getByCategory(Integer categoryID) {

        List<Post> categoryList = postRepository.findAllByCategoryID(categoryID);
        return categoryList;
    }

    public List<Post> getByRegion(Integer regionId) {
        List<Post> regionList = postRepository.findAllByRegioID(regionId);
        return regionList;
    }

    public List<Post> getByTitle(String title) {

        List<Post> titleList = postRepository.findAllByTitle(title);
        return titleList;
    }

    public Integer getViewCounts(Integer id) {
        Post post = getPost(id);
        return post.getViewCount();
    }

    public boolean toPublish(Integer postID) {
        Post post = getPost(postID);
        post.setPostStatus(PostTypes.PUBLISHED);
        postRepository.save(post);
        return true;
    }
}
