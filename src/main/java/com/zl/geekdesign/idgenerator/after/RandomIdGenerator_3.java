package com.zl.geekdesign.idgenerator.after;


import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * 异常处理重构
 * Create by zhanglong on 2020/3/26
 */
public class RandomIdGenerator_3 implements LogTraceIdGenerator {
    private static final Logger logger = LoggerFactory.getLogger(RandomIdGenerator_3.class);

    @Override
    public String generate() {
        String substrOfHostName = null;
        try {
            substrOfHostName = getLastFiledHostName();
        } catch (UnknownHostException e) {
            throw new IdGenerationFailureException("host name is empty.");
        }
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        return String.format("%s-%d-%s",
                substrOfHostName, currentTimeMillis, randomString);
    }

    private String getLastFiledHostName() throws UnknownHostException {
        String hostName = InetAddress.getLocalHost().getHostName();
        if (StringUtils.isEmpty(hostName)) throw new UnknownHostException("hostName is null");
        return getLastSubstrSplittedByDot(hostName);
    }

    @VisibleForTesting
    protected String getLastSubstrSplittedByDot(String hostName) {
        if (StringUtils.isEmpty(hostName)) throw new IllegalArgumentException("hostName is null");
        String[] tokens = hostName.split("\\.");
        return tokens[tokens.length - 1];
    }

    @VisibleForTesting
    protected String generateRandomAlphameric(int length) {
        if (length <= 0) throw new IllegalArgumentException("length can't less or equals 0");
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) randomChars[count++] = (char) randomAscii;

        }
        return new String(randomChars);
    }


}
