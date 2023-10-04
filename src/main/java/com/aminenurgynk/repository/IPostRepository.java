package com.aminenurgynk.repository;

import com.aminenurgynk.repository.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {

      List<Post> findPostsByUserId(Long id);

      List<Post> getPostsByCategoryId(Long id);

      List<Post> findAllByContentContainingIgnoreCase(String value);



}
