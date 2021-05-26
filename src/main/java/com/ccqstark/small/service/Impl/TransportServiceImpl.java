package com.ccqstark.small.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccqstark.small.dao.TransportMapper;
import com.ccqstark.small.model.Transport;
import com.ccqstark.small.service.ITransportService;
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
public class TransportServiceImpl extends ServiceImpl<TransportMapper, Transport> implements ITransportService {

}
