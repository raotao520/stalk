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
    public List<Card> findAllByStatus(Integer status) {
        return cardRepsitory.findAllByStatus(status);
    }

    @Override
    public Card save(Card card) {
        return cardRepsitory.save(card);
    }
}
