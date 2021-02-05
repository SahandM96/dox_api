package com.sahandm96.dox.domain;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Images {
    String imageId;

    public Images(String imageId) {
        this.imageId = imageId;
    }
}
