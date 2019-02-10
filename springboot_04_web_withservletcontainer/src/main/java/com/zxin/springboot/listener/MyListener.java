package com.zxin.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// 实现的是 监听容器启动的两个Listener
public class MyListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized...web应用启动!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed...当前web项目销毁!");
    }
}
