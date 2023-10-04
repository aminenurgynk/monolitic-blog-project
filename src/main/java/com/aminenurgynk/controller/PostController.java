package com.aminenurgynk.controller;


import com.aminenurgynk.dto.response.PostResponseDto;
import com.aminenurgynk.exception.ResourceNotFoundException;
import com.aminenurgynk.repository.entity.Post;
import com.aminenurgynk.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.aminenurgynk.constant.RestApiUrl.*;

import java.util.List;


//GET http://localhost:8080/post
@RestController
@RequestMapping(POST)
public class PostController {

    @Autowired
    PostService postService;

    //GET http://localhost:8080/post/getAllPosts
    @GetMapping(GETALLPOSTS)
    public ResponseEntity<List<PostResponseDto>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    //GET http://localhost:8080/post/getPostById/1
    @GetMapping(GETPOST_BYID)
    public ResponseEntity<Post> getPostById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    //POST http://localhost:8080/post/createPost
    @PostMapping(CREATEPOST)
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.createPost(post));
    }

    //PUT http://localhost:8080/post/updatePostById/2
    @PutMapping(UPDATEPOST_BYID)
    public ResponseEntity<Post> updatePostById(@PathVariable(value = "id") Long id, @RequestBody Post post) throws ResourceNotFoundException {

        Post postInfo = getPostById(id).getBody();
        if (postInfo != null) {
            postInfo.setId(id);
            postInfo.setTitle(post.getTitle());
            postInfo.setContent(post.getContent());
            postInfo.setPublished(post.getPublished());
            return ResponseEntity.ok(postService.updatePostById(postInfo));
        }
        return null;
    }

    //DELETE http://localhost:8080/post/deletePostById/3
    @DeleteMapping(DELETEPOST_BYID)
    public ResponseEntity<String> deletePostById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(postService.deletePostById(id));
    }


    //GET http://localhost:8080/post/getAllPostsByUserId/5
    @GetMapping(GETALLPOST_BYUSERID)
    public ResponseEntity<List<Post>> getAllPostsByUserId(@PathVariable(value = "userid") Long id) {
        return ResponseEntity.ok(postService.getAllPostsByUserId(id));
    }

    //GET http://localhost:8080/post/getAllPostsByCategoryId/4
    @GetMapping(GETALLPOST_BYCATEGORYID)
    public ResponseEntity<List<Post>> getAllPostsByCategoryId(@PathVariable(value = "categoryid") Long id) {

        return ResponseEntity.ok(postService.getAllPostsByCategoryId(id));
    }


    //GET http://localhost:8080/post/api/search/aim
    @GetMapping(FINDPOSTS_SEARCH)
    public ResponseEntity<List<Post>> findAllByContentContainingIgnoreCase(@PathVariable(value = "value") String value){
        return ResponseEntity.ok(postService.findAllByContentContainingIgnoreCase(value));
    }

}




