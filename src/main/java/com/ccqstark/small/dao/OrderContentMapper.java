package com.ccqstark.small.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ccqstark.small.dto.CartListUnit;
import com.ccqstark.small.model.OrderContent;
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
public interface OrderContentMapper extends BaseMapper<OrderContent> {

}
