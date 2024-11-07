package com.example.quizApp.Repository;

import com.example.quizApp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface questionRepository extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);
    List<Question> findByCategoryAndDifficultyLevel(String category, String difficultyLevel);
}



