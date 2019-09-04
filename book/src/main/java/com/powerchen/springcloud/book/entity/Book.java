package com.powerchen.springcloud.book.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: powerchen
 * @Date: 2019/9/4 11:17
 */
@Entity
@Table(name = "t_book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bid;
    private String sn;
    private String name;
    private String author;
    private String publishing;
    private Float bprice;
    private Float sprice;
    private String btype;
    private Integer stock;
}
