package com.huijia.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.huijia.common.mybatis.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 经销商对象 dealer
 *
 * @author huijia
 * @date 2023-12-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("dealer")
public class Dealer extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 产品id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 代理人
     */
    private String agent;

    /**
     * 代理商邮箱
     */
    private String email;

    /**
     * 经销商公司
     */
    private String company;


    private Long userId;
    /**
     * 用户性别
     */
    private Long sex;

    /**
     * 手机
     */
    private String phone;

    /**
     * 序列号
     */
    private String sn;


}
