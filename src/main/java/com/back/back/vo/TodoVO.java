package com.back.back.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TodoVO {
    private Long id;
    private String title;
    private String content;
    private int completed;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expectedCompleteDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateAt;
}
