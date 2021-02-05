package com.sahandm96.dox.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CostumeLinks {
    @Id
    private String id;

    private String LinkName;
    private String LinkData;
    private String LinkDescription;

    public CostumeLinks() {}

    public CostumeLinks(String linkName, String linkData) {
        LinkName = linkName;
        LinkData = linkData;
    }

    public CostumeLinks(String linkName, String linkData, String linkDescription) {
        LinkName = linkName;
        LinkData = linkData;
        LinkDescription = linkDescription;
    }
}
