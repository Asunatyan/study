package com.example.designpatterns.part01.common.pro;

import com.example.designpatterns.part01.common.RequestStat;

import java.util.Map;

public interface StatViewer {
    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills);
}



