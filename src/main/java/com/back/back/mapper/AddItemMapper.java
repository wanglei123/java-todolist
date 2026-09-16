package com.back.back.mapper;

import com.back.back.dto.AddItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddItemMapper {

    int insert(AddItem item);

    List<AddItem> searchAll();

    int deleteById(int id);

    int updateById(AddItem item);
}
