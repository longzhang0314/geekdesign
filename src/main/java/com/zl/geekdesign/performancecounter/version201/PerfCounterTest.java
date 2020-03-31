package com.zl.geekdesign.performancecounter.version201;

import com.zl.geekdesign.performancecounter.bo.RequestInfo;

import java.util.Collections;

/**
 * 调用
 * Create by zhanglong on 2020/3/27
 */
public class PerfCounterTest {
    public static void main(String[] args) {
        MetricsStorage storage = new RedisMetricsStorage();
        Aggregator aggregator = new Aggregator();

        //定时触发统计并将结果显示到终端
        ConsoleViewer consoleViewer = new ConsoleViewer();
        ConsoleReporter consoleReporter = new ConsoleReporter(storage, aggregator, consoleViewer);
        consoleReporter.startRepeatedReport(60, 60);

        //定时触发并将结果输出到邮件
        EmailViewer emailViewer = new EmailViewer();
        emailViewer.addAddress(Collections.singletonList("zhanglong@xiaoxiangyoupin.com"));
        EmailReporter emailReporter = new EmailReporter(storage, aggregator, emailViewer);
        emailReporter.startDailyReport();

        //收集接口访问数据
        MetricsCollector collector = new MetricsCollector(storage);
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 231, 21412));
        collector.recordRequest(new RequestInfo("register", 221, 342421));
        collector.recordRequest(new RequestInfo("register", 121563, 45326));

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
