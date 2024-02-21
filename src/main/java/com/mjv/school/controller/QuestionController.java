package com.mjv.school.controller;

import com.mjv.school.dto.QuestionDTO;
import com.mjv.school.model.Question;
import com.mjv.school.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> findAllQuestion(){
        return new ResponseEntity<>(questionService.findAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<QuestionDTO> findQuestionById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(questionService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<QuestionDTO> saveQuestion(@RequestBody QuestionDTO questionDTO) throws Exception {
        return new ResponseEntity<>(questionService.saveQuestion(questionDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteQuestion(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}