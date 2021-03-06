package com.example.designpatterns.part01.common.pro;

import com.example.designpatterns.part01.common.EmailSender;
import com.example.designpatterns.part01.common.RequestStat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmailViewer implements StatViewer {
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();

    public EmailViewer() {
        this.emailSender = new EmailSender(/*省略参数*/);
    }

    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public EmailViewer(List<String> emailToAddresses) {

    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    public void output(
            Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills) {
        // format the requestStats to HTML style.
        // send it to email toAddresses.
    }
}