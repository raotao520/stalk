package com.hxt.stalk.controller;

import com.hxt.stalk.dataobject.Card;
import com.hxt.stalk.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/data")
    public List<Card> findStatusList(){

        List<Integer> list = Arrays.asList(1,4);

        List<Card> cards = cardService.findByStatusIn(list);
        System.out.println(cards);
        return cards;
    }

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
