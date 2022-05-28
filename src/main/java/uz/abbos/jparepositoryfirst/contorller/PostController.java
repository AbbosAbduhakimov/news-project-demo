package uz.abbos.jparepositoryfirst.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.abbos.jparepositoryfirst.entity.Post;
import uz.abbos.jparepositoryfirst.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable("id") Integer id){
        Post result = postService.getPost(id);
        return ResponseEntity.ok(result);
    }


    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post){
        Post result = postService.createPost(post);
        return ResponseEntity.ok(result);
    }


    @PutMapping("{id}")
    public ResponseEntity<?> updatePost(@PathVariable Integer id,
                                        @RequestBody Post post){
        Post result = postService.updatePost(id,post);
        return ResponseEntity.ok(result);
    }


    @PutMapping("/publish/{id}")
    public ResponseEntity<?> accesToPublish(@PathVariable("id")Integer postID){
        boolean result = postService.toPublish(postID);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer id){
        boolean result = postService.deletePost(id);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/category/{id}")
    public ResponseEntity<?> getByCategory(@PathVariable("id") Integer categoryID){
        List<Post> result = postService.getByCategory(categoryID);
        return ResponseEntity.ok(result);
    }


    @GetMapping("region/{id}")
    public ResponseEntity<?> getByRegion(@PathVariable ("id") Integer regionId){
        List<Post> result = postService.getByRegion(regionId);
        return ResponseEntity.ok(result);
    }


    @GetMapping("title/{title}")
    public ResponseEntity<?> getByTitle(@PathVariable("title") String title){
        List<Post> result = postService.getByTitle(title);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/view/{viewCount}")
    public ResponseEntity<?> getViewCounts(@PathVariable("viewCount") Integer id){
        Integer result = postService.getViewCounts(id);
        return ResponseEntity.ok(result);
    }

}
