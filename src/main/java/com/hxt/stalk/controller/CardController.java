package com.hxt.stalk.controller;

import com.hxt.stalk.dataobject.Card;
import com.hxt.stalk.service.CardService;
import com.hxt.stalk.util.SoundSpeakerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/speaker")
public class CardController {

    @Autowired
    CardService cardService;

    @GetMapping("/list1")
    public String list(Model model){

        List<Card> cards =cardService.findAll();

        model.addAttribute("cards",cards);
        return "qianduan1";
    }

    @GetMapping("/list2")
    public String list2list(Model model){

        List<Card> cards =cardService.findAll();

        model.addAttribute("cards",cards);
        return "qianduan2";
    }
}
