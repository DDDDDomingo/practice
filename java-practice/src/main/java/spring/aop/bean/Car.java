package spring.aop.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @description: 车子
 * @author: yifan
 * @date: 2019/8/20 16:13
 */
@Data
@ToString
public class Car {
    private String name;
    private String length;
    private String width;
    private String height;
    private Wheel wheel;
}
