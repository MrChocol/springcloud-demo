package com.powerchen.springcloud.book.repository;

import com.powerchen.springcloud.book.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: powerchen
 * @Date: 2019/9/4 11:25
 */
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

}
