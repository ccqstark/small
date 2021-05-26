package com.ccqstark.small.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccqstark.small.dao.CartMapper;
import com.ccqstark.small.model.Cart;
import com.ccqstark.small.service.ICartService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ccqstark
 * @since 2021-05-26
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {


}
