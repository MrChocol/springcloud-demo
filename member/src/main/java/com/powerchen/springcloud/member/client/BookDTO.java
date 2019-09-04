package com.powerchen.springcloud.member.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: powerchen
 * @Date: 2019/9/4 16:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
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
