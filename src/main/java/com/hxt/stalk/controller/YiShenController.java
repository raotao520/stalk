package com.hxt.stalk.controller;

import com.hxt.stalk.dataobject.Card;
import com.hxt.stalk.service.CardService;
import com.hxt.stalk.util.SoundSpeakerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/yishen")
public class YiShenController {

    @Autowired
    CardService cardService;
    SoundSpeakerUtil soundSpeakerUtil = new SoundSpeakerUtil();

    @GetMapping("/list")
    public List<Card> findStatusList(){

        List<Integer> list = Arrays.asList(0,1);

        return cardService.findByStatusIn(list);
    }
    @PostMapping("/yishenhujiao")
    public void speakList(@RequestParam("id") Integer id){
        Card card = cardService.findCardsById(id);

        if (card.getSelect() == "一审") {
            soundSpeakerUtil.getSound(card);
        }else {
            card.setSelect("一审");
            card.setStatus(1);
            cardService.save(card);
            soundSpeakerUtil.getSound(card);
        }
    }

    @PostMapping("/yishenspeak")
    public void speaker(@RequestParam("number") String number){
        Card card = new Card();
        card.setNumber(number);
        card.setSelect("一审");
        card.setStatus(1);
        if (cardService.findCardByNumber(number) == null) {
            cardService.save(card);
            soundSpeakerUtil.getSound(card);
        }else {
            soundSpeakerUtil.getSound(card);
        }
    }

    @PostMapping("/hege")
    public void updateCard(@RequestParam("id") Integer id){
        Card card = cardService.findCardsById(id);
        card.setSelect("一审");
        card.setStatus(0);
        cardService.save(card);
    }
}
