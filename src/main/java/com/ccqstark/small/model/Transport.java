package com.ccqstark.small.model;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ccqstark
 * @since 2021-05-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Transport对象", description="")
public class Transport implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "运输单号")
    @TableId
    private Integer transportId;

    @ApiModelProperty(value = "同种商品")
    private Integer cartId;

    @ApiModelProperty(value = "运输阶段")
    private Integer stage;

    @ApiModelProperty(value = "当前所在地点")
    private String address;

    @ApiModelProperty(value = "到达地点时间")
    private LocalDateTime arrivalTime;


}
