package com.hxt.stalk.service.serviceimpl;

import com.hxt.stalk.dataobject.Card;
import com.hxt.stalk.repsitory.CardRepsitory;
import com.hxt.stalk.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepsitory cardRepsitory;

    @Override
    public List<Card> findAll() {
        return cardRepsitory.findAll();
    }

    @Override
    public List<Card> findByStatusIn(List<Integer> list) {
        return cardRepsitory.findByStatusIn(list);
    }

    @Override
    public Card save(Card card) {
        return cardRepsitory.save(card);
    }

    @Override
    public Card updata(Integer id, String window, Integer status) {

        Card card = cardRepsitory.findCardById(id);
        card.setWindow(window);
        card.setStatus(status);
        return cardRepsitory.save(card);
    }

    @Override
    public Card findCardById(Integer id) {
        return cardRepsitory.findCardById(id);
    }

    @Override
    public Card findCardByNumber(String number) {
        return cardRepsitory.findCardByNumber(number);
    }

    @Override
    public List<Card> findCardsByStatus(Integer status) {
        return cardRepsitory.findCardsByStatus(status);
    }



}
