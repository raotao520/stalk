package com.hxt.stalk.controller;

import com.hxt.stalk.dataobject.Card;
import com.hxt.stalk.service.CardService;
import com.hxt.stalk.util.SoundSpeakerUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/ziliao")
public class ZiLiaoController {
    @Autowired
    CardService cardService;
    SoundSpeakerUtil soundSpeakerUtil = new SoundSpeakerUtil();

    @GetMapping("/list")
    public String findStatusList(Model model){

        List<Integer> list = Arrays.asList(1,4);

        List cards = cardService.findByStatusIn(list);
        model.addAttribute("cards",cards);
        return "ziliao";
    }
    @GetMapping("/ziliaohujiao")
    @ResponseBody
    public void speakList(Integer id){
        Integer status = new Integer(4);
        Card card = cardService.findCardById(id);
        card.setWindow("资料录入");
        System.out.println(card);
        soundSpeakerUtil.getSound(card);
        cardService.save(card);

    }

    @RequestMapping(value = "/speak",method = RequestMethod.POST)
    @ResponseBody
    public void speaker(String number){
        Card card = new Card();
        card.setNumber(number);
        card.setWindow("资料录入");
        card.setStatus(4);
        if (cardService.findCardByNumber(card.getNumber()) == null) {

            soundSpeakerUtil.getSound(card);
            cardService.save(card);
        }else {
            soundSpeakerUtil.getSound(card);
        }
    }

}
