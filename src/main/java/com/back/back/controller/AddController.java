/*
 * @Author       : wanglei
 * @Date         : 2026-09-14 15:02:10
 * @LastEditors  : wanglei
 * @LastEditTime : 2026-09-16 15:36:15
 * @FilePath     : /back/src/main/java/com/back/back/controller/AddController.java
 * @description  : 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package com.back.back.controller;

import com.back.back.dto.AddItem;
import com.back.back.service.AddItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class AddController {

    private final AddItemService addItemService;

    public AddController(AddItemService addItemService) {
        this.addItemService = addItemService;
    }

    @PostMapping
    @RequestMapping("/add")
    public AddItem add(@RequestBody AddItem item) {
        return addItemService.add(item);
    }

    @PostMapping
    @RequestMapping("/list")
    public List<AddItem> search(){
        return addItemService.search();
    }

    @PostMapping
    @RequestMapping("/delete/{id}")
    public int deleteItem(@PathVariable int id){
        return addItemService.deleteById(id);
    }

    @PostMapping
    @RequestMapping("/update")
    public int updateById(@RequestBody AddItem item){
        return addItemService.updateById(item);
    }


}
