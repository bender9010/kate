package com.kate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Item(Long id) {
        this.id = id;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public Item(){}

    public Item(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    private String name;
    private Long count;


}
