/*
 * @Author       : wanglei
 * @Date         : 2026-09-18 10:30:12
 * @LastEditors  : wanglei
 * @LastEditTime : 2026-09-20 10:31:26
 * @FilePath     : /back/src/main/java/com/back/back/dto/TodoDTO.java
 * @description  : 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package com.back.back.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TodoDTO {
    private Long id;

    @NotBlank(message = "title 不能为空")
    private String title;

    @NotBlank(message = "content 不能为空")
    private String content;
    private Integer completed;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expectedCompleteDate;
}

