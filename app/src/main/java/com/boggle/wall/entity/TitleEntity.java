package com.boggle.wall.entity;

public class TitleEntity {
    private String title;
    private String titleDes;

    public TitleEntity(String title, String titleDes) {
        this.title = title;
        this.titleDes = titleDes;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleDes() {
        return titleDes;
    }
}
