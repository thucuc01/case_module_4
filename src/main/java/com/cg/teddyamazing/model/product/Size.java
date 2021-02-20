package com.cg.teddyamazing.model.product;

import javax.persistence.*;

@Entity
@Table
public class Size {
    @Id
    private String id;
    @Column(unique = true)
    private String name;

    public Size() {
    }

    public Size(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}