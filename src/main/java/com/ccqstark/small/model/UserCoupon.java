package com.ccqstark.small.model;

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
@ApiModel(value="UserCoupon对象", description="")
public class UserCoupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户")
    private Integer userId;

    @ApiModelProperty(value = "优惠券")
    private Integer couponId;

    @ApiModelProperty(value = "数量")
    private Integer number;


}
