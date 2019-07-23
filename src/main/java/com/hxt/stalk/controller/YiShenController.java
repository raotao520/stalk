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
@RequestMapping("/yishen")
public class YiShenController {

    @Autowired
    CardService cardService;
    SoundSpeakerUtil soundSpeakerUtil = new SoundSpeakerUtil();

    @GetMapping("/list")
    public String findStatusList(Model model){

        List<Integer> list = Arrays.asList(1,4,0);

        List cards = cardService.findByStatusIn(list);
        model.addAttribute("cards",cards);
        return "yishen";
    }

    /**
     * 不合格按钮
     * @param id
     */
    @PostMapping("/lose")
    @ResponseBody
    public void successList(Integer id){
        Card card = cardService.findCardById(id);

        if (card.getWindow() == "一审") {
            soundSpeakerUtil.getSound(card);
        }else {
            card.setWindow("一审");
            card.setStatus(1);
            soundSpeakerUtil.getSound(card);
            cardService.save(card);
        }
    }

    @PostMapping("/success")
    @ResponseBody
    public void loseList(Integer id){
        Card card = cardService.findCardById(id);
        card.setWindow("一审");
        card.setStatus(0);
        cardService.save(card);
    }

    @RequestMapping(value = "/speak",method = RequestMethod.POST)
    @ResponseBody
    public void speaker(String number){
        Card card = new Card();
        card.setNumber(number);
        card.setWindow("一审");
        card.setStatus(1);
        if (cardService.findCardByNumber(number) == null) {
            cardService.save(card);
            soundSpeakerUtil.getSound(card);
        }else {
            soundSpeakerUtil.getSound(card);
        }
    }
}
