package com.back.back.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoVO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime updateAt;
}
