package com.ccqstark.small.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ccqstark.small.common.CommonResult;
import com.ccqstark.small.common.ResultCode;
import com.ccqstark.small.dao.CartMapper;
import com.ccqstark.small.model.Cart;
import com.ccqstark.small.model.User;
import com.ccqstark.small.service.Impl.CartServiceImpl;
import com.ccqstark.small.service.Impl.OrderInfoServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderInfoServiceImpl orderInfoService;

    @ApiOperation("订单确认")
    @PostMapping("/confirm/{receiverId}")
    @Transactional
    public CommonResult<Map<String, Object>> orderConfirm(@PathVariable("receiverId") int receiverId, HttpSession session) {

        // 未登录
        if (session.isNew() || session.getAttribute("user") == null) {
            return CommonResult.failed(ResultCode.UNAUTHORIZED);
        }
        int userId = ((User) session.getAttribute("user")).getUserId();

        String orderId = orderInfoService.confirmOrder(receiverId, userId);
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", orderId);

        return CommonResult.success(map);
    }

    @ApiOperation("获得订单详情")
    @GetMapping("/info/{orderId}")
    public CommonResult getOrderInfo(@PathVariable("orderId") String orderId) {
        return CommonResult.success(orderInfoService.getOrderInfo(orderId));
    }

}
