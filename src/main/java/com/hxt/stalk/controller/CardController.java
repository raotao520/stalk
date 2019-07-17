package com.hxt.stalk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <Description> <br>
 *
 * @author RRR
 * @version 1.0
 * @taskId:
 * @createDate 2019/07/16 16:09
 * @see com.hxt.stalk.controller
 */
@RestController
@RequestMapping("/speaker")
public class CardController {

    @GetMapping("/list")
    public void list(){

    }
}
