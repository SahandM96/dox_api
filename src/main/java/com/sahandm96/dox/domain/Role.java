package com.sahandm96.dox.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Role {
    /**
     * Role 0 is User == costumer
     * Role 1 is BranchOwner == manger
     * Role 2 is BranchAdmin == Admin != manger
     * Role 3 is DeliveryGay
     */
    @Id
    public String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

    private ERole name;

    public Role() {
    }

    public Role(ERole name) {
        this.name = name;
    }
    
}
