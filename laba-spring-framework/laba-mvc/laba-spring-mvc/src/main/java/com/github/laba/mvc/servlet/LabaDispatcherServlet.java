package com.github.laba.mvc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * DispatchServlet 实现
 * - 加载指定配置文件 mvc.properties
 * - 包扫描，扫描注解
 * - - @LabaController
 * - - @LabaRequestMapping
 * - - @LabaService
 * - IoC进行相应的Bean初始化及依赖注入
 * - 构造一个HandlerMapping处理器映射器，建立 URL 与 Method 的映射关系
 * - 等待请求进入，进行后续处理
 *
 * @author laba zhang
 */
public class LabaDispatcherServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 加载指定配置文件 mvc.properties
        String contextLocation = config.getInitParameter("contextLocation");
        LabaDispatcherServletSupport.doLoadContextConfig(contextLocation);

        // 根据注解获取Bean，构造一个HandlerMapping处理器映射器，建立 URL 与 Method 的映射关系


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
