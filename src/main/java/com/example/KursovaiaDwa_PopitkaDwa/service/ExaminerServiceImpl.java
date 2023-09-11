package com.example.KursovaiaDwa_PopitkaDwa.service;

import com.example.KursovaiaDwa_PopitkaDwa.dto.Question;
import com.example.KursovaiaDwa_PopitkaDwa.exception.NotEnoughQuestions;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();

        if (questionService.getAll().stream().distinct().count() < amount) {
            throw new NotEnoughQuestions();
        }

        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }

        return questions;
    }
}
