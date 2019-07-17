package com.hxt.stalk.repsitory;

import com.hxt.stalk.dataobject.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepsitory extends JpaRepository<Card,Integer> {

    Card findCardsById(Integer id);
    List<Card> findAllByStatus(Integer status);

}
