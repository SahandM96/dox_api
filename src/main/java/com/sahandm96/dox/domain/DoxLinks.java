package com.sahandm96.dox.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class DoxLinks {
    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

    private String LinkData;
    private DoxLinksSlang LinkSlang;
    private String LinkDescription;


    public DoxLinks(){}

    public DoxLinks(String linkData, DoxLinksSlang linkSlang, String linkDescription) {
        LinkData = linkData;
        LinkSlang = linkSlang;
        LinkDescription = linkDescription;
    }

    public DoxLinks(String linkData, DoxLinksSlang linkSlang) {
        LinkData = linkData;
        LinkSlang = linkSlang;
    }
}
