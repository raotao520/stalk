package com.hxt.stalk.service;

import com.hxt.stalk.dataobject.Card;

import java.util.List;


public interface CardService {

    List<Card> findAll();

    List<Card> findByStatusIn(List<Integer> list);

    Card save(Card card);

    Card updata(Integer id ,String select, Integer status);

    Card findCardsById(Integer id);

    Card findCardByNumber(String number);

    List<Card> findCardsByStatus(Integer integer);

}
