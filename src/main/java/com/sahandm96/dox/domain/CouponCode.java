package com.sahandm96.dox.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@Document
public class CouponCode {
    @Id
    private String id;
    private String Code;
    private Date date;
    private Integer NumberOfUser;

}
