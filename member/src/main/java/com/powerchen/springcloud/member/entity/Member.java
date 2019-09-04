package com.powerchen.springcloud.member.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: powerchen
 * @Date: 2019/9/3 17:15
 */

@Entity
@Table(name = "t_member")
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;
    private String name;
    private String idno;
    private String mobile;
    private Date regdate;
    private Date expdate;
}
