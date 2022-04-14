package com.wzbc.video.params;

import lombok.Data;

import java.util.List;

@Data
public class NoteAndNew {
    private String token;

    private String name;

    private List<Picture> picture;

    private List<Picture> file;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Picture> getPicture() {
        return picture;
    }

    public void setPicture(List<Picture> picture) {
        this.picture = picture;
    }

    public List<Picture> getFile() {
        return file;
    }

    public void setFile(List<Picture> file) {
        this.file = file;
    }
}
