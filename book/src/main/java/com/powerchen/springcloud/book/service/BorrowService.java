package com.powerchen.springcloud.book.service;

import com.powerchen.springcloud.book.repository.BorrowRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: powerchen
 * @Date: 2019/9/4 11:29
 */
@Service
public class BorrowService {
    @Resource
    private BorrowRepository borrowRepository;

}
