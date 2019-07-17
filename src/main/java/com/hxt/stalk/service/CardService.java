package com.hxt.stalk.service;

import com.hxt.stalk.dataobject.Card;

import java.util.List;


public interface CardService {

    List<Card> findAll();

    List<Card> findAllByStatus(Integer status);

    Card save(Card card);

}
