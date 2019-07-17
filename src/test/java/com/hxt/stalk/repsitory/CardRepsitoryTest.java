package com.hxt.stalk.repsitory;

import com.hxt.stalk.dataobject.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * <Description> <br>
 *
 * @author RRR
 * @version 1.0
 * @taskId:
 * @createDate 2019/07/16 12:30
 * @see com.hxt.stalk.repsitory
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CardRepsitoryTest {

    @Autowired
    private CardRepsitory cardRepsitory;

    @Test
    public void findOneTest(){
        Card card = cardRepsitory.findCardsById(2);
        System.out.println(card.toString());
    }
}