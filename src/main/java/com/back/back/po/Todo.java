package com.back.back.po;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Todo {
    private Long id;
    private String title;
    private String content;
    private Boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
