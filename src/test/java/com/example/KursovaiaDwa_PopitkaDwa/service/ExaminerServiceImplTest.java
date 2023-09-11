package com.example.KursovaiaDwa_PopitkaDwa.service;

import com.example.KursovaiaDwa_PopitkaDwa.dto.Question;
import com.example.KursovaiaDwa_PopitkaDwa.exception.NotEnoughQuestions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    private final QuestionService questionService = mock(QuestionService.class);
    private final ExaminerServiceImpl underTest = new ExaminerServiceImpl(questionService);
    @Test
    void getQuestions_throwException() {
        Set<Question> questions = new HashSet<>();

        when(questionService.getAll()).
                thenReturn(questions);

        NotEnoughQuestions ex = assertThrows(NotEnoughQuestions.class, () ->
                underTest.getQuestions(1));
    }

    @Test
    void getQuestion_correctWork() {
        Set<Question> questions = new HashSet<>();
        Question qOne = new Question("What", "You");
        questions.add(qOne);
        when(questionService.getAll()).
                thenReturn(questions);

        when(questionService.getRandomQuestion()).thenReturn(qOne);

        Collection<Question> result = underTest.getQuestions(1);

        assertIterableEquals(questions, result);
    }
}