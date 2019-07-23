package com.hxt.stalk.controller;

import com.hxt.stalk.dataobject.Card;
import com.hxt.stalk.service.CardService;
import com.hxt.stalk.util.SoundSpeakerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/dazheng")
public class DaZhengController {

    @Autowired
    CardService cardService;
    SoundSpeakerUtil soundSpeakerUtil = new SoundSpeakerUtil();

    @GetMapping("/list")
    public String findStatusList(Model model){
        List<Integer> list = Arrays.asList(0,2);
        List cards = cardService.findByStatusIn(list);
        model.addAttribute("cards",cards);
        return "dazheng";
    }

    @RequestMapping("/update")
    @ResponseBody
    public void updateStatus(Integer id){
        Card card = cardService.findCardById(id);
        card.setWindow("制证打证");
        card.setStatus(2);
        soundSpeakerUtil.getSound(card);
        cardService.save(card);
    }

    @RequestMapping("/last")
    @ResponseBody
    public void updateStatuslast(Integer id) {
        Card card = cardService.findCardById(id);
        card.setStatus(3);
        cardService.save(card);
    }
}
