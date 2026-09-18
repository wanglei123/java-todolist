/*
 * @Author       : wanglei
 * @Date         : 2026-09-14 15:02:10
 * @LastEditors  : wanglei
 * @LastEditTime : 2026-09-16 15:36:15
 * @FilePath     : /back/src/main/java/com/back/back/controller/TodoController.java
 * @description  : 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package com.back.back.controller;

import com.back.back.dto.TodoDTO;
import com.back.back.service.TodoService;
import com.back.back.vo.TodoVO;
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
    public TodoVO add(@RequestBody TodoDTO dto) {
        return todoService.add(dto);
    }

    @PostMapping
    @RequestMapping("/list")
    public List<TodoVO> search(){
        return todoService.search();
    }

    @PostMapping
    @RequestMapping("/delete/{id}")
    public int deleteItem(@PathVariable int id){
        return todoService.deleteById(id);
    }

    @PostMapping
    @RequestMapping("/update")
    public int updateById(@RequestBody TodoDTO dto){
        return todoService.updateById(dto);
    }

    @PostMapping
    @RequestMapping("/getDetailById/{id}")
    public TodoVO getDetailById(@PathVariable int id){
        return todoService.selectById(id);
    }


}
