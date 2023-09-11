package com.example.KursovaiaDwa_PopitkaDwa.service;

import com.example.KursovaiaDwa_PopitkaDwa.dto.Question;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final List<Question> questions;

    private final Random random;

    public QuestionServiceImpl() {
        this.questions = new ArrayList<>();
        random = new Random();
    }

    @Override

    public Question add(String question, String answer) {
        Question questionEntity = new Question(question, answer);
        add(questionEntity);
        return questionEntity;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        return questions.get(random.nextInt(questions.size()));
    }
}