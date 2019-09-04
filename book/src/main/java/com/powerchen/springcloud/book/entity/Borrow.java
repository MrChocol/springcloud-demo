package com.powerchen.springcloud.book.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: powerchen
 * @Date: 2019/9/4 11:17
 */
@Entity
@Table(name = "t_borrow")
@Data
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brid;
    private Long bid;
    private Long mid;
    private Date takedate;
    private Date returndate;
    private Date createtime;
}
