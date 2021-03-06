package com.example.designpatterns.part01.common.pro.plus;


import com.example.designpatterns.part01.common.MetricsStorage;
import com.example.designpatterns.part01.common.RedisMetricsStorage;
import com.example.designpatterns.part01.common.pro.Aggregator;
import com.example.designpatterns.part01.common.pro.EmailViewer;
import com.example.designpatterns.part01.common.pro.StatViewer;

import java.util.List;

public class EmailReporter extends ScheduledReporter {
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
    public EmailReporter(List<String> emailToAddresses) {
        this(new RedisMetricsStorage(), new Aggregator(), new EmailViewer(emailToAddresses));
    }

    // 兼顾灵活性和代码的可测试性，这个构造函数继续保留
    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
    }
// 省略其他代码...
}