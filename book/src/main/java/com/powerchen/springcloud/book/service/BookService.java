package com.powerchen.springcloud.book.service;

import com.powerchen.springcloud.book.client.MemberClient;
import com.powerchen.springcloud.book.client.MemberDTO;
import com.powerchen.springcloud.book.client.RestResult;
import com.powerchen.springcloud.book.entity.Book;
import com.powerchen.springcloud.book.entity.Borrow;
import com.powerchen.springcloud.book.repository.BookRepository;
import com.powerchen.springcloud.book.repository.BorrowRepository;
import com.powerchen.springcloud.book.service.exception.BookNotFoundException;
import com.powerchen.springcloud.book.service.exception.MemberNotFoundException;
import com.powerchen.springcloud.book.service.exception.NotEnoughStockException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author: powerchen
 * @Date: 2019/9/4 11:29
 */
@Service
public class BookService {
    @Resource
    private BookRepository bookRepository;
    @Resource
    private MemberClient memberClient;
    @Resource
    private BorrowRepository borrowRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book getInfo(Long bid) {
        Optional<Book> optional = bookRepository.findById(bid);
        Book book;
        if (optional.isPresent()) {
            book = optional.get();
        } else {
            throw new BookNotFoundException("BOOKID: " + bid + " not found!");
        }
        return book;
    }

    public void borrow(Long bid, String mobile, Date takeDate, Date returnDate) {
        Optional<Book> optional = bookRepository.findById(bid);
        Book book;
        if (!optional.isPresent()) {
            throw new BookNotFoundException("BOOKID: " + bid + " not found!");
        } else {
            book = optional.get();
        }
        if (book.getStock() <= 0) {
            throw new NotEnoughStockException("Stock Not Enough!");
        }

        MemberDTO memberDTO;
        RestResult<MemberDTO> restResult = memberClient.checkMobiles(mobile);
        if ("0".equals(restResult.getCode())) {
            memberDTO = restResult.getData();
        } else {
            throw new MemberNotFoundException("Member Not Found!");
        }

        Borrow borrow = new Borrow();
        borrow.setBid(book.getBid());
        borrow.setMid(memberDTO.getMid());
        borrow.setTakedate(takeDate);
        borrow.setReturndate(returnDate);
        borrow.setCreatetime(new Date());

        borrowRepository.saveAndFlush(borrow);

        book.setStock(book.getStock() - 1);
        bookRepository.saveAndFlush(book);
    }
}
