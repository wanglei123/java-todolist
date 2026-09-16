package com.back.back.service;

import com.back.back.dto.AddItem;

import java.util.List;

public interface AddItemService {

    // 新增
    AddItem add(AddItem item);

    // 查看
    List<AddItem> search();

    // 根据id删除
    int deleteById(int id);

    // 根据id更新
    int updateById(AddItem item);
}

