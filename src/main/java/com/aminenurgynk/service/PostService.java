package com.aminenurgynk.service;

import com.aminenurgynk.dto.response.PostResponseDto;
import com.aminenurgynk.exception.ResourceNotFoundException;
import com.aminenurgynk.mapper.IPostMapper;
import com.aminenurgynk.repository.IPostRepository;
import com.aminenurgynk.repository.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    IPostRepository postRepository;

    public List<PostResponseDto> getAllPosts(){
        List<Post> postList = postRepository.findAll();
        if (postList.isEmpty()){
            throw new RuntimeException("No data was found");
        }
        return IPostMapper.INSTANCE.toPostResponseDtos(postList);
    }

    public Post getPostById(Long id) throws ResourceNotFoundException  {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post could not found!!"));
        return postRepository.findById(id).get();
    }

    public Post createPost(Post post){
        return postRepository.save(post);
    }

    public Post updatePostById(Post postInfo) throws ResourceNotFoundException {
        Post post = postRepository.findById(postInfo.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Post could not found!!"));
        return postRepository.save(postInfo);
    }

    public String deletePostById(Long id) throws ResourceNotFoundException {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post could not found!!"));
        postRepository.deleteById(id);
        return "The post has been deleted from the database";
    }

    public List<Post> getAllPostsByUserId(Long id) {
        List<Post> postList = postRepository.findPostsByUserId(id);
        if (postList.isEmpty()){
            throw new RuntimeException("No data was found");
        }
        return postList;
    }

    public List<Post>getAllPostsByCategoryId(Long id) {

        List<Post> postList = postRepository.getPostsByCategoryId(id);
        if (postList.isEmpty()){
            throw new RuntimeException("No data was found");
        }
        return postList;
     }


    public List<Post> findAllByContentContainingIgnoreCase(String value) {
        List<Post> postList = postRepository.findAllByContentContainingIgnoreCase(value);
        if (postList.isEmpty()){
            throw new RuntimeException("No data was found");
        }
        return postList;
    }
}
