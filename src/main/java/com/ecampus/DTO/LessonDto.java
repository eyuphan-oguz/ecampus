package com.ecampus.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LessonDto {
    private String lessonName;
    private int credit;
}
