package service;

import builder.AlternativeMapper;
import dto.AlternativeDTO;
import model.Alternative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AlternativeRepository;

import java.util.List;

@Service
public class AlternativeService {

    @Autowired
    AlternativeRepository alternativeRepository;

    @Autowired
    AlternativeMapper alternativeMapper;

    public List<AlternativeDTO> findAllAlternatives() {
        return alternativeMapper.toListDTO(alternativeRepository.findAll());
    }

    public AlternativeDTO findAlternativeById(Long id) throws Exception {
        return alternativeMapper.toDTO(alternativeRepository.findById(id).orElseThrow(Exception::new));
    }

    public AlternativeDTO saveAlternative(AlternativeDTO alternativeDTO){
        return alternativeMapper.toDTO(alternativeRepository.save(alternativeMapper.toEntity(alternativeDTO)));
    }

    public void deleteAlternative(Long id) throws Exception {
        alternativeRepository.delete(alternativeMapper.toEntity(findAlternativeById(id)));
    }

    public AlternativeDTO updateAlternative(AlternativeDTO newAlternative, Long id) throws Exception {
        Alternative updatedAlternative = alternativeRepository.findById(id).orElseThrow(Exception::new);

        updatedAlternative.setAlternative(newAlternative.getAlternative());
        updatedAlternative.setItsCorrect(newAlternative.isItsCorrect());

        return alternativeMapper.toDTO(alternativeRepository.save(updatedAlternative));
    }

}