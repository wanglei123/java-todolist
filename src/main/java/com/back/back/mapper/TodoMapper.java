package com.back.back.mapper;

import com.back.back.po.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    int insert(Todo todo);

    List<Todo> searchAll();

    int deleteById(int id);

    int updateById(Todo todo);

    Todo selectById(int id);
}
