package com.mjv.school.builder;

import com.mjv.school.dto.AlternativeDTO;
import com.mjv.school.model.Alternative;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlternativeMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public AlternativeMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public AlternativeDTO toDTO(Alternative model){
        return modelMapper.map(model, AlternativeDTO.class);
    }

    public Alternative toEntity(AlternativeDTO dto){
        return modelMapper.map(dto, Alternative.class);
    }

    public List<AlternativeDTO> toListDTO(List<Alternative> modelList){
        return modelList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    public List<Alternative> toList(List<AlternativeDTO> modelList){
        return modelList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

}
