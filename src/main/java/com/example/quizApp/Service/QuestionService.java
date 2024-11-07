package com.example.quizApp.Service;

import com.example.quizApp.Model.Question;
import com.example.quizApp.Repository.questionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    questionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> findQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public List<Question> findQuestionsByCategoryAndDifficulty(String category, String difficultyLevel) {
        return questionRepository.findByCategoryAndDifficultyLevel(category, difficultyLevel);
    }

    public List<Question> getRandomQuestions(int count) {
        List<Question> questions = questionRepository.findAll();
        Collections.shuffle(questions);
        return questions.subList(0, Math.min(count, questions.size()));
    }
}
