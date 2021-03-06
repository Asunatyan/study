package com.example.designpatterns.part01.common.pro.plus;

import com.example.designpatterns.part01.common.MetricsStorage;
import com.example.designpatterns.part01.common.RedisMetricsStorage;

public class MetricsCollector {
    private MetricsStorage metricsStorage; // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数

    public MetricsCollector() {
        this(new RedisMetricsStorage());
    } // 兼顾灵活性和代码的可测试性，这个构造函数继续保留

    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    } // 省略其他代码...
}