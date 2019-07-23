package com.hxt.stalk.controller;

import com.hxt.stalk.dataobject.Card;
import com.hxt.stalk.service.CardService;
import com.hxt.stalk.util.SoundSpeakerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/dazheng")
public class DaZhengController {

    @Autowired
    CardService cardService;
    SoundSpeakerUtil soundSpeakerUtil = new SoundSpeakerUtil();

    @GetMapping("/list1")
    public List<Card> findStatusList(){

        Integer status = new Integer(0);

        return cardService.findCardsByStatus(status);
    }

    @GetMapping("/list2")
    public List<Card> findList(){

        Integer status = new Integer(2);

        return cardService.findCardsByStatus(status);
    }

    @PostMapping("/update")
    public void updateStatus(@RequestParam("id") Integer id){
        Card card = cardService.findCardById(id);
        card.setWindow("制证打证");
        card.setStatus(2);
        soundSpeakerUtil.getSound(card);
    }

    @PostMapping("/last")
    public void updateStatuslast(@RequestParam("id") Integer id) {
        Card card = cardService.findCardById(id);
        card.setStatus(3);
    }
}
