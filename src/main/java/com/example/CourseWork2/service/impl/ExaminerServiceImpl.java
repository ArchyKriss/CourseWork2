package com.example.CourseWork2.service.impl;

import com.example.CourseWork2.ExaminerService;
import com.example.CourseWork2.Question;
import com.example.CourseWork2.service.JavaQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    private void initializeQuestions (){
        Set<Question> uniqueQuestions = new HashSet<>();
        while (uniqueQuestions.size()<10){
            uniqueQuestions.add(javaQuestionService::addQuestion);
        }
    }


    @Override
    public List<Question> getQuestions(int amount) {
        List<Question> allQuestions = javaQuestionService.findAllQuestions();
        if(amount>allQuestions.size()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Недостаточно вопросов");
        }
        return allQuestions.subList(0, amount);
    }
}
