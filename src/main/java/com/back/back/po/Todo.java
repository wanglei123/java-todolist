package com.back.back.po;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Todo {
    private Long id;
    private String title;
    private String content;
    private Integer completed;
    private LocalDate expectedCompleteDate;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
