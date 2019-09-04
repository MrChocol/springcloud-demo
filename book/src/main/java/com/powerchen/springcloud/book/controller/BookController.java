package com.powerchen.springcloud.book.controller;

import com.powerchen.springcloud.book.client.RestResult;
import com.powerchen.springcloud.book.entity.Book;
import com.powerchen.springcloud.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: powerchen
 * @Date: 2019/9/4 11:06
 */
@RestController
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public Map list() {
        Map result = new HashMap();
        try {
            List<Book> all = bookService.findAll();
            result.put("code", "0");
            result.put("message", "success");
            result.put("data", all);
        } catch (Exception e) {
            result.put("code", e.getClass().getSimpleName());
            result.put("message", e.getMessage());
        }
        return result;
    }

    @GetMapping("/info")
    public Map list(Long bid) {
        Map result = new HashMap();
        try {
            Book book = bookService.getInfo(bid);
            result.put("code", "0");
            result.put("message", "success");
            result.put("data", book);
        } catch (Exception e) {
            result.put("code", e.getClass().getSimpleName());
            result.put("message", e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/borrow")
    public RestResult borrow(Long bid, String mobile, String takedate, String returndate) {
        Date tDate = null;
        Date rDate = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            tDate = simpleDateFormat.parse(takedate);
            rDate = simpleDateFormat.parse(returndate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        RestResult<Object> restResult = new RestResult<>();
        try {
            bookService.borrow(bid, mobile, tDate, rDate);
            restResult.setCode("0");
            restResult.setMessage("success");
        } catch (Exception e) {
            restResult.setCode(e.getClass().getSimpleName());
            restResult.setMessage(e.getMessage());
        }
        return restResult;
    }

}
