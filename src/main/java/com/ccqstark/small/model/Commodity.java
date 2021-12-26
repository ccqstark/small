package com.ccqstark.small.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

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
@ApiModel(value="Commodity对象", description="")
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    @TableId(value = "cod_id", type = IdType.AUTO)
    private Integer codId;

    @Min(1)
    @ApiModelProperty(value = "所属卖家")
    private Integer shopId;

    @NotBlank
    @ApiModelProperty(value = "商品名称")
    private String codName;

    @Min(0)
    @ApiModelProperty(value = "单价")
    private BigDecimal price;

    @Min(0)
    @ApiModelProperty(value = "库存")
    private Integer stock;

    @NotBlank
    @ApiModelProperty(value = "图片")
    private String image;


}
