package com.example.designpatterns.part01.common.pro.plus;


import com.example.designpatterns.part01.common.MetricsStorage;
import com.example.designpatterns.part01.common.RedisMetricsStorage;
import com.example.designpatterns.part01.common.pro.Aggregator;
import com.example.designpatterns.part01.common.pro.ConsoleViewer;
import com.example.designpatterns.part01.common.pro.StatViewer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ConsoleReporter extends ScheduledReporter {
    private ScheduledExecutorService executor;

    // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
    public ConsoleReporter() {
        this(new RedisMetricsStorage(), new Aggregator(), new ConsoleViewer());
    } // 兼顾灵活性和代码的可测试性，这个构造函数继续保留

    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
        this.executor = Executors.newSingleThreadScheduledExecutor();
    } // 省略其他代码...
}