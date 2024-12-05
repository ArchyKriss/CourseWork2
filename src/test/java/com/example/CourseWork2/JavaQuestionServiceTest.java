package com.example.CourseWork2;

import com.example.CourseWork2.service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp(){
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    void testAddQuestion() {
        Question question = new Question("Что такое Java?", "Язык программирования");
        javaQuestionService.addQuestion(question);

        List<Question> questions = javaQuestionService.findAllQuestions();
        assertEquals(1, questions.size());
        assertEquals(question, questions.get(0));
    }

    @Test
    void testRemoveQuestion() {
        Question question = new Question("Что такое Java?", "Язык программирования");
        javaQuestionService.addQuestion(question);
        javaQuestionService.removeQuestion(question);

        List<Question> questions = javaQuestionService.findAllQuestions();
        assertTrue(questions.isEmpty());
    }

    @Test
    void testFindAllQuestions() {
        Question question1 = new Question("Что такое Java?", "Язык программирования");
        Question question2 = new Question("Что такое OOP?", "Объектно-ориентированное программирование");

        javaQuestionService.addQuestion(question1);
        javaQuestionService.addQuestion(question2);

        List<Question> questions = javaQuestionService.findAllQuestions();
        assertEquals(2, questions.size());
        assertTrue(questions.contains(question1));
        assertTrue(questions.contains(question2));
    }

    @Test
    void testGetRandomQuestion() {
        Question question1 = new Question("Что такое Java?", "Язык программирования");
        Question question2 = new Question("Что такое OOP?", "Объектно-ориентированное программирование");

        javaQuestionService.addQuestion(question1);
        javaQuestionService.addQuestion(question2);

        Question randomQuestion = javaQuestionService.getRandomQuestion();
        assertNotNull(randomQuestion);
        assertTrue(randomQuestion.equals(question1) || randomQuestion.equals(question2));
    }

    @Test
    void testGetRandomQuestionFromEmptyList() {
        assertNull(javaQuestionService.getRandomQuestion());
    }

}
