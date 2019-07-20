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
     * 资料录入
     * @return
     */
    @GetMapping("/ziliao")
    public List<Card> findStatusList(){

        List<Integer> list = Arrays.asList(1,4);

        return cardService.findByStatusIn(list);
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

    /**
     * 打证
     * @return
     */
    @GetMapping("/dazhjeng")
    public List<Card> findDaZheng(){

        List<Integer> list = Arrays.asList(0,2);

        return cardService.findByStatusIn(list);
    }


    /**
     * 保存和更新
     * @param number
     * @param select
     * @param status
     */
    @PostMapping("/save")
    public void saveCard(@RequestParam("number") String number,
                         @RequestParam("select" ) String select,
                         @RequestParam("status") Integer status){
        Card card = new Card();
        card.setNumber(number);
        card.setSelect(select);
        card.setStatus(status);
        cardService.save(card);
    }

}
