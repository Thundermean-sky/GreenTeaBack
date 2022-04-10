package com.mean.greentea.entity;

import lombok.Data;

@Data
public class Comic {
    private String CID;
    private String name;
    private String author;
    private float episodes;
    private String lastUpdate;
    private String comicType;
    private String viewUrl;
    private String introduction;
    private String imgUrl;
    private String states;
}
