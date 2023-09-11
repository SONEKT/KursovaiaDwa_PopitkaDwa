package com.example.KursovaiaDwa_PopitkaDwa.service;

import com.example.KursovaiaDwa_PopitkaDwa.dto.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
