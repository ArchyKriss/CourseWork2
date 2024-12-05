package com.example.CourseWork2.controller;

import com.example.CourseWork2.Question;
import com.example.CourseWork2.service.JavaQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;


    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @PostMapping("add")
    public void addQuestion (@RequestParam String question, @RequestParam String answer){
        javaQuestionService.addQuestion(new Question(question,answer));
    }

    @PostMapping("/remove")
    public void removeQuestion (@RequestParam String question, @RequestParam String answer){
        javaQuestionService.removeQuestion(new Question(question, answer));
    }

    @GetMapping
    public List<Question> getAllQuestions(){
        return javaQuestionService.findAllQuestions();
    }

}