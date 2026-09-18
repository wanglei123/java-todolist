package com.back.back.service;

import com.back.back.dto.TodoDTO;
import com.back.back.vo.TodoVO;

import java.util.List;

public interface TodoService {

    // 新增
    TodoVO add(TodoDTO dto);

    // 查看
    List<TodoVO> search();

    // 根据id删除
    int deleteById(int id);

    // 根据id更新
    int updateById(TodoDTO dto);

    // 根据id查询详情
    TodoVO selectById(int id);
}
