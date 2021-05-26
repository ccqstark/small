package com.ccqstark.small.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ccqstark
 * @description druid配置类
 * @date 2021/2/20 8:30 下午
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Bean
    // 后台监控
    public ServletRegistrationBean statViewServlet() {

        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        // 存储账号密码
        HashMap<String, String> initParameters = new HashMap<>();

        // 设置后台登录账号密码
        initParameters.put("loginUsername", "ccq");
        initParameters.put("loginPassword", "123456");

        // 任何人都可以访问
        initParameters.put("allow", "");

        // 设置初始化参数
        bean.setInitParameters(initParameters);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        // 被过滤的请求
        Map<String, String> initParameters = new HashMap<>();

        initParameters.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParameters);

        return bean;
    }

    // 为了一次性执行多条sql而做个性化wall配置
    @Bean
    public WallConfig wallConfig() {
        WallConfig wallConfig = new WallConfig();
        wallConfig.setMultiStatementAllow(true);    // 允许一次执行多条语句
        wallConfig.setNoneBaseStatementAllow(true); // 允许一次执行多条语句
        return wallConfig;
    }

    @Bean
    public WallFilter wallFilter() {
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig());
        return wallFilter;
    }


}

