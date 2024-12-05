package com.example.CourseWork2.service;

import com.example.CourseWork2.Question;
import com.example.CourseWork2.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final List<Question> questions = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public void addQuestion(Question question) {
        question.add(question);

    }

    @Override
    public void removeQuestion(Question question) {
        question.remove(question);

    }

    @Override
    public List<Question> findAllQuestions() {
        return new ArrayList<>(questions);
    }

    public Question getRandomQuestion(){
        if(questions.isEmpty()){
            return null;
        }
        return questions.get(random.nextInt(questions.size()));
    }
}
