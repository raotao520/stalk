package com.hxt.stalk.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 车牌号
     */
    private String number;

    /**
     * 窗口号
     */
    private String window;

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
     *
     * status = 0 等待打证
     * status = 1 不合格
     * status = 2 等待领取合格证
     * status = 3 办理完结
     * status = 4 资料录入和一审
     */
    private Integer status;

    public Card() {
    }

    public Card(String number, String window, Date createData, Date updateData, Integer status) {
        this.number = number;
        this.window = window;
        this.createData = createData;
        this.updateData = updateData;
        this.status = status;
    }
}
