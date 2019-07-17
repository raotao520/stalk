package com.hxt.stalk.service;

import com.hxt.stalk.dataobject.Card;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author RRR
 * @version 1.0
 * @taskId:
 * @createDate 2019/07/16 12:43
 * @see com.hxt.stalk.service
 */
public interface CardService {

    List<Card> findAll();

    List<Card> findAllByStatus(Integer status);

    Card save(Card card);

}
