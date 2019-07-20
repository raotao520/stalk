package com.hxt.stalk.controller;

import com.hxt.stalk.dataobject.Card;
import com.hxt.stalk.service.CardService;
import com.hxt.stalk.util.SoundSpeakerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ziliao")
public class ZiLiaoController {
    @Autowired
    CardService cardService;
    SoundSpeakerUtil soundSpeakerUtil = new SoundSpeakerUtil();

    @GetMapping("/list")
    public List<Card> findStatusList(){

        List<Integer> list = Arrays.asList(1,4);

        return cardService.findByStatusIn(list);
    }
    @PostMapping("/hujiao")
    public void speakList(@RequestParam("id") Integer id){
        Card card = cardService.findCardsById(id);

        if (card.getSelect() == "资料录入") {
            soundSpeakerUtil.getSound(card);
        }else {
            card.setSelect("资料录入");
            card.setStatus(4);
            cardService.save(card);
            soundSpeakerUtil.getSound(card);
        }
    }

    @PostMapping("/speak")
    public void speaker(@RequestParam("number") String number){
        Card card = new Card();
        card.setNumber(number);
        card.setSelect("资料录入");
        card.setStatus(4);
        if (cardService.findCardByNumber(number) == null) {
            cardService.save(card);
            soundSpeakerUtil.getSound(card);
        }else {
            soundSpeakerUtil.getSound(card);
        }
        
    }

}
