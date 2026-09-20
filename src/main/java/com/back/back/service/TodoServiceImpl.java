package com.back.back.service;

import com.back.back.dto.TodoCompletedDTO;
import com.back.back.dto.TodoDTO;
import com.back.back.mapper.TodoMapper;
import com.back.back.po.Todo;
import com.back.back.vo.TodoVO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoMapper todoMapper;

    public TodoServiceImpl(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    @Override
    public TodoVO add(TodoDTO dto) {
        if (dto == null || dto.getContent() == null || dto.getContent().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "content 不能为空");
        }
        if (dto.getTitle() != null) {
            dto.setTitle(dto.getTitle().trim());
        }
        dto.setContent(dto.getContent().trim());
        Todo todo = toTodo(dto);
        todoMapper.insert(todo);
        return toTodoVO(todoMapper.selectById(todo.getId().intValue()));
    }

    @Override
    public List<TodoVO> search() {
        List<Todo> todos = todoMapper.searchAll();
        List<TodoVO> result = new ArrayList<>();
        for (Todo todo : todos) {
            result.add(toTodoVO(todo));
        }
        return result;
    }

    @Override
    public int deleteById(int id) {
        return todoMapper.deleteById(id);
    }

    @Override
    public int updateById(TodoDTO dto) {
        return todoMapper.updateById(toTodo(dto));
    }

    @Override
    public int updateCompleted(TodoCompletedDTO dto) {
        if (dto == null || dto.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id 不能为空");
        }
        if (dto.getCompleted() == null || (dto.getCompleted() != 0 && dto.getCompleted() != 1)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "completed 只能是 0 或 1");
        }
        Todo todo = new Todo();
        todo.setId(dto.getId());
        todo.setCompleted(dto.getCompleted() == 1);
        return todoMapper.updateCompleted(todo);
    }

    @Override
    public TodoVO selectById(int id) {
        return toTodoVO(todoMapper.selectById(id));
    }

    private Todo toTodo(TodoDTO dto) {
        Todo todo = new Todo();
        todo.setId(dto.getId());
        todo.setTitle(dto.getTitle());
        todo.setContent(dto.getContent());
        todo.setCompleted(dto.getCompleted() != null && dto.getCompleted() == 1);
        todo.setExpectedCompleteDate(dto.getExpectedCompleteDate());
        return todo;
    }

    private TodoVO toTodoVO(Todo todo) {
        if (todo == null) {
            return null;
        }
        TodoVO vo = new TodoVO();
        vo.setId(todo.getId());
        vo.setTitle(todo.getTitle());
        vo.setContent(todo.getContent());
        vo.setCompleted(Boolean.TRUE.equals(todo.getCompleted()) ? 1 : 0);
        vo.setExpectedCompleteDate(todo.getExpectedCompleteDate());
        vo.setUpdateAt(todo.getUpdateAt());
        return vo;
    }
}
