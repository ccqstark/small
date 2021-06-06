package com.ccqstark.small.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccqstark.small.dao.CartMapper;
import com.ccqstark.small.dao.OrderContentMapper;
import com.ccqstark.small.dao.OrderInfoMapper;
import com.ccqstark.small.model.Cart;
import com.ccqstark.small.model.OrderContent;
import com.ccqstark.small.model.OrderInfo;
import com.ccqstark.small.service.IOrderInfoService;
import org.omg.CORBA.SetOverrideType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ccqstark
 * @since 2021-05-26
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private OrderContentServiceImpl orderContentService;

    /**
     * 订单确认
     */
    @Override
    public String confirmOrder(int receiverId, int userId) {

        // 生存订单号uuid
        String orderId = IdUtil.simpleUUID();

        // 新建一个order
        orderInfoMapper.insert(new OrderInfo(orderId, receiverId, "-", BigDecimal.valueOf(0), null, 0));

        // 把当前的购物车选中的商品加入订单关系表
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<Cart>()
                .eq("user_id", userId)
                .eq("selected", 1)
                .eq("to_order", 0);
        List<Cart> cartList = cartMapper.selectList(queryWrapper);

        List<OrderContent> orderContentList = new ArrayList<>();
        for (Cart cart : cartList) {
            orderContentList.add(new OrderContent(orderId, cart.getCartId(), userId));
        }

        orderContentService.saveBatch(orderContentList);

        // 更新to_order
        UpdateWrapper<Cart> updateWrapper = new UpdateWrapper<Cart>()
                .set("to_order", 1)
                .eq("selected", 1)
                .eq("to_order", 0);
        cartMapper.update(null, updateWrapper);

        return orderId;
    }

}
