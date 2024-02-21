package service;

import builder.QuestionMapper;
import dto.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.QuestionRepository;

import java.util.Objects;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionMapper questionMapper;

    public QuestionDTO saveQuestion(QuestionDTO questionDto) throws Exception {
        Long newQuestionId = null;
        if (Objects.nonNull(questionDto.getId())) {
            newQuestionId = questionDto.getId();
            if (questionRepository.existsById(newQuestionId)) {
                throw new Exception();
            } else {
                return questionMapper.toDTO(questionRepository.save(questionMapper.toEntity(questionDto)));
            }
        } else {
            return questionMapper.toDTO(questionRepository.save(questionMapper.toEntity(questionDto)));
        }
    }

    public void deleteQuestion(Long id){
        questionRepository.deleteById(id);
    }

    public QuestionDTO findById(Long id) throws Exception {
        return questionMapper.toDTO(questionRepository.findById(id).orElseThrow(Exception::new));
    }

}