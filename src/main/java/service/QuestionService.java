package service;

import builder.QuestionMapper;
import dto.QuestionDTO;
import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.QuestionRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionMapper questionMapper;

    public List<Question> findAllQuestions() {
        return questionRepository.findAll();
    }

    public QuestionDTO findById(Long id) throws Exception {
        return questionMapper.toDTO(questionRepository.findById(id).orElseThrow(Exception::new));
    }

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

    public Question updateQuestion(Question question) {
        Optional<Question> questionController = questionRepository.findById(question.getId());
        return questionRepository.save(questionController.get());
    }

}
