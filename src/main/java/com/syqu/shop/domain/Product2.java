package com.syqu.shop.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "productnew")
public class Product2 {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;


}
