package com.example.KursovaiaDwa_PopitkaDwa;

import com.example.KursovaiaDwa_PopitkaDwa.dto.Question;
import com.example.KursovaiaDwa_PopitkaDwa.service.QuestionServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionServiceImplTest {

	QuestionServiceImpl underTest = new QuestionServiceImpl();

	Question question1 = new Question("Q1", "A1");
	Question question2 = new Question("Q2", "A2");

	@Test
	void add__questionAddedAndReturn() {
		Question result = underTest.add(question1.getQuestion(), question1.getAnswer());

		assertTrue(underTest.getAll().contains(question1));
		assertEquals(question1, result);
	}

	@Test
	void remove() {
		underTest.add(question1.getQuestion(), question1.getAnswer());
		Question result = underTest.remove(question1);

		assertFalse(underTest.getAll().contains(question1));
	}

	@Test
	void getAll_questionsAreInList_listReturned() {
		underTest.add(question1);
		underTest.add(question2);

		Collection<Question> result = underTest.getAll();

		assertEquals(List.of(question1, question2), result);
	}

	@Test
	void getRandomQuestion() {
		Question result = underTest.add(question1.getQuestion(), question1.getAnswer());

		assertTrue(underTest.getAll().contains(question1));
		assertEquals(question1, result);
	}
}