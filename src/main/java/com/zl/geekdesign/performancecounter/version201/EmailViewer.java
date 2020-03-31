package com.zl.geekdesign.performancecounter.version201;

import com.zl.geekdesign.performancecounter.bo.EmailSender;
import com.zl.geekdesign.performancecounter.bo.RequestStat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Create by zhanglong on 2020/3/27
 */
public class EmailViewer implements StatViewer {
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();

    public EmailViewer() {
        this.emailSender = new EmailSender(/*.省略参数.*/);
    }

    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void addAddress(List<String> toAddresses) {
        this.toAddresses = toAddresses;
    }

    @Override
    public void optput(Map<String, RequestStat> requestStat, long startTimeInMillis, long endTimeInMillis) {
        // format the requestStats to HTML style.
        // send it to email toAddresses.
    }
}
