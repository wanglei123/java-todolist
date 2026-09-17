package com.back.back.service;

import com.back.back.dto.AddItem;
import com.back.back.mapper.AddItemMapper;
import com.back.back.po.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddItemServiceImpl implements AddItemService {

    private final AddItemMapper addItemMapper;

    public AddItemServiceImpl(AddItemMapper addItemMapper) {
        this.addItemMapper = addItemMapper;
    }

    @Override
    public AddItem add(AddItem item) {
        if (item == null || item.getContent() == null || item.getContent().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "content 不能为空");
        }
        if (item.getTitle() != null) {
            item.setTitle(item.getTitle().trim());
        }
        item.setContent(item.getContent().trim());
        Todo todo = toTodo(item);
        addItemMapper.insert(todo);
        item.setId(todo.getId());
        return item;
    }

    @Override
    public List<AddItem> search() {
        List<Todo> todos = addItemMapper.searchAll();
        List<AddItem> result = new ArrayList<>();
        for (Todo todo : todos) {
            result.add(toAddItem(todo));
        }
        return result;
    }

    @Override
    public int deleteById(int id) {
        return addItemMapper.deleteById(id);
    }

    @Override
    public int updateById(AddItem item) {
        return addItemMapper.updateById(toTodo(item));
    }

    @Override
    public AddItem selectById(int id) {
        return toAddItem(addItemMapper.selectById(id));
    }

    private Todo toTodo(AddItem item) {
        Todo todo = new Todo();
        todo.setId(item.getId());
        todo.setTitle(item.getTitle());
        todo.setContent(item.getContent());
        return todo;
    }

    private AddItem toAddItem(Todo todo) {
        if (todo == null) {
            return null;
        }
        AddItem item = new AddItem();
        item.setId(todo.getId());
        item.setTitle(todo.getTitle());
        item.setContent(todo.getContent());
        return item;
    }
}
