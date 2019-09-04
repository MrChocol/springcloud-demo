package com.powerchen.springcloud.book.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: powerchen
 * @Date: 2019/9/3 17:15
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Long mid;
    private String name;
    private String idno;
    private String mobile;
    private Date regdate;
    private Date expdate;
}
