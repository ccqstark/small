package com.ccqstark.small.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ccqstark.small.dto.CartListUnit;
import com.ccqstark.small.model.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ccqstark
 * @since 2021-05-26
 */
@Repository
public interface CartMapper extends BaseMapper<Cart> {

    List<CartListUnit> getCartList(@Param("user_id") int userId);

    List<CartListUnit> getCartSelectedList(@Param("user_id") int userId);

}
