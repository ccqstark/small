package com.ccqstark.small.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ccqstark.small.common.CommonResult;
import com.ccqstark.small.dao.*;
import com.ccqstark.small.model.Commodity;
import com.ccqstark.small.model.OrderInfo;
import com.ccqstark.small.model.Shop;
import com.ccqstark.small.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sys")
public class SystemController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @GetMapping("/info")
    public CommonResult getSysInfo() {
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        QueryWrapper<User> queryWrapperUser = new QueryWrapper<>();
        Integer userNum = userMapper.selectCount(queryWrapperUser);
        QueryWrapper<Shop> queryWrapperShop = new QueryWrapper<>();
        Integer shopNum = shopMapper.selectCount(queryWrapperShop);
        QueryWrapper<Commodity> queryWrapperCod = new QueryWrapper<>();
        Integer codNum = commodityMapper.selectCount(queryWrapperCod);
        QueryWrapper<OrderInfo> queryWrapperOrderInfo = new QueryWrapper<>();
        Integer orderNum = orderInfoMapper.selectCount(queryWrapperOrderInfo);
        resultMap.put("userNum", userNum);
        resultMap.put("shopNum", shopNum);
        resultMap.put("codNum", codNum);
        resultMap.put("orderNum", orderNum);

        return CommonResult.success(resultMap);
    }

}
