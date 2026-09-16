package com.back.back.service;

import com.back.back.dto.AddItem;
import com.back.back.mapper.AddItemMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        item.setContent(item.getContent().trim());
        addItemMapper.insert(item);
        return item;
    }

    @Override
    public List<AddItem> search() {
        return addItemMapper.searchAll();
    }

    @Override
    public int deleteById(int id) {
        return addItemMapper.deleteById(id);
    }

    @Override
    public int updateById(AddItem item) {
        return addItemMapper.updateById(item);
    }
}
