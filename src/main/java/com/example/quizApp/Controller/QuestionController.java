package com.example.quizApp.Controller;

import com.example.quizApp.Model.Question;
import com.example.quizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/all")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category) {
        return questionService.findQuestionsByCategory(category);
    }

    @GetMapping("/category/{category}/difficulty/{difficulty}")
    public List<Question> getQuestionsByCategoryAndDifficulty(
            @PathVariable String category,
            @PathVariable String difficulty
    ) {
        return questionService.findQuestionsByCategoryAndDifficulty(category, difficulty);
    }

    @GetMapping("/random/{count}")
    public List<Question> getRandomQuestions(@PathVariable int count) {
        return questionService.getRandomQuestions(count);
    }
}

