package com.ccqstark.small.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
@ApiModel(value="Cart对象", description="")
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "购物车中的一种商品的id")
    @TableId(value = "cart_id", type = IdType.AUTO)
    private Integer cartId;

    @ApiModelProperty(value = "所属客户")
    private Integer userId;

    @ApiModelProperty(value = "商品id")
    private Integer codId;

    @ApiModelProperty(value = "购买数量")
    private Integer buyNumber;

    @ApiModelProperty(value = "是否已经加入到订单")
    private Integer toOrder;

}
