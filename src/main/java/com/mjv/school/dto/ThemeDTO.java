package com.mjv.school.dto;

import com.mjv.school.model.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ThemeDTO {

    private String theme;
    private Long id;
    private List<Question> questionList = new ArrayList<>();

}