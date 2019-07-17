package com.hxt.stalk.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Data
@Entity
@DynamicUpdate
public class Card {

    /**
     * id
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 车牌号
     */
    private String number;

    /**
     * 窗口号
     */
    private String select;

    /**
     * 创建时间
     */
    private Date createData;

    /**
     * 更新时间
     */
    private Date updateData;

    /**
     * 车辆状态
     */
    private Integer status;

}
