package com.pipocando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pipocando.domain.blog.PostEvaluation;

import java.util.List;

@Repository
public interface PostEvaluationRepository extends JpaRepository<PostEvaluation, Integer> {
    List<PostEvaluation> findByPostId(Integer postId);
    List<PostEvaluation> findByUserId(Integer userId);
}
