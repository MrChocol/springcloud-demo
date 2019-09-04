package com.powerchen.springcloud.book.repository;

import com.powerchen.springcloud.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: powerchen
 * @Date: 2019/9/4 11:25
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}
