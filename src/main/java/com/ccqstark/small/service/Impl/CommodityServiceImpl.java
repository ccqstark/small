package com.ccqstark.small.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccqstark.small.dao.CommodityMapper;
import com.ccqstark.small.model.Commodity;
import com.ccqstark.small.service.ICommodityService;
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
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {

}
