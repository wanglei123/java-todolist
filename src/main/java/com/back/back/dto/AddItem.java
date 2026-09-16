package com.back.back.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class AddItem {
    private Long id;
    private String title; // 标题
    private String content; // 内容

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        AddItem addItem = (AddItem) o;
        return Objects.equals(id, addItem.id) && Objects.equals(title, addItem.title) && Objects.equals(content, addItem.content);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(title);
        result = 31 * result + Objects.hashCode(content);
        return result;
    }

    @Override
    public String toString() {
        return "AddItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
