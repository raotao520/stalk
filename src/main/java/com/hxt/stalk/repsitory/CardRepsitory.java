package com.hxt.stalk.repsitory;

import com.hxt.stalk.dataobject.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author RRR
 * @version 1.0
 * @taskId:
 * @createDate 2019/07/16 12:25
 * @see com.hxt.stalk.repsitory
 */
public interface CardRepsitory extends JpaRepository<Card,Integer> {

    Card findCardsById(Integer id);
    List<Card> findAllByStatus(Integer status);

}
