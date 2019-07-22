package com.hxt.stalk.controller;

import com.hxt.stalk.dataobject.Card;
import com.hxt.stalk.service.CardService;
import com.hxt.stalk.util.SoundSpeakerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/speaker")
public class CardController {

    @Autowired
    CardService cardService;

    @GetMapping("/list")
    public List<Card> list(){

        List<Card> card =cardService.findAll();

        return card;
    }

    /**
     * 一审窗口列表显示
     * 传入状态，用于动态显示屏显示
     * @param
     * @return
     */
    @GetMapping("/yisheng")
    public List<Card> find1Shen(){

        List<Integer> list = Arrays.asList(1,0);

        return cardService.findByStatusIn(list);
    }

}
