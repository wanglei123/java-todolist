/*
 * @Author       : wanglei
 * @Date         : 2026-09-14 15:02:10
 * @LastEditors  : wanglei
 * @LastEditTime : 2026-09-16 15:36:15
 * @FilePath     : /back/src/main/java/com/back/back/controller/TodoController.java
 * @description  : 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package com.back.back.controller;

import com.back.back.common.Result;
import com.back.back.dto.TodoCompletedDTO;
import com.back.back.dto.TodoDTO;
import com.back.back.service.TodoService;
import com.back.back.vo.TodoVO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    @RequestMapping("/add")
    public Result<TodoVO> add(@Valid @RequestBody TodoDTO dto) {
        return Result.success(todoService.add(dto));
    }

    @PostMapping
    @RequestMapping("/list")
    public Result<List<TodoVO>> search(){
        return Result.success(todoService.search());
    }

    @PostMapping
    @RequestMapping("/delete/{id}")
    public Result<Boolean> deleteItem(@PathVariable Long id){
        return Result.success(todoService.deleteById(id));
    }

    @PostMapping
    @RequestMapping("/update")
    public Result<TodoVO> updateById(@Valid @RequestBody TodoDTO dto){
        return Result.success(todoService.updateById(dto));
    }

    @PostMapping
    @RequestMapping("/updateCompleted")
    public Result<Boolean> updateCompleted(@RequestBody TodoCompletedDTO dto){
        return Result.success(todoService.updateCompleted(dto));
    }

    @PostMapping
    @RequestMapping("/getDetailById/{id}")
    public Result<TodoVO> getDetailById(@PathVariable Long id){
        return Result.success(todoService.selectById(id));
    }


}
