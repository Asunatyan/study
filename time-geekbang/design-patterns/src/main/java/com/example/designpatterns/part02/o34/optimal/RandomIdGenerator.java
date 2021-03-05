package com.example.designpatterns.part02.o34.optimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/3/4 14:50<br/>
 *
 * @author <br/>
 * @since JDK 1.8
 */
public class RandomIdGenerator implements LogTraceIdGenerator {
    private static final Logger logger = LoggerFactory.getLogger(RandomIdGenerator.class);

    @Override
    public String generate() {
        String substrOfHostName = getLastfieldOfHostName();
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        return String.format("%s-%d-%s",
                substrOfHostName, currentTimeMillis, randomString);
    }

    private String getLastfieldOfHostName(){

        //对于 generate() 函数，如果本机名获取失败，函数返回什么？这样的返回值是否合理？
        String substrOfHostName = null;
        try {
            String hostName = InetAddress.getLocalHost().getHostName();

            substrOfHostName = getLastSubstrSplittedByDot(hostName);

            /*String[] tokens = hostName.split("\\.");
            substrOfHostName = tokens[tokens.length - 1];*/
            return substrOfHostName;
        } catch (UnknownHostException e) {
            //对于 getLastFiledOfHostName() 函数，是否应该将 UnknownHostException 异常在函数内部吞掉（try-catch 并打印日志）？
            // 还是应该将异常继续往上抛出？如果往上抛出的话，是直接把 UnknownHostException 异常原封不动地抛出，还是封装成新的异常抛出？
            logger.warn("Failed to get the host name.", e);
        }
        return substrOfHostName;
    }

    protected String getLastSubstrSplittedByDot(String hostName) {
        //对于 getLastSubstrSplittedByDot(String hostName) 函数，如果 hostName 为 NULL 或者是空字符串，这个函数应该返回什么？
        String[] tokens = hostName.split("\\.");
        return tokens[tokens.length - 1];
    }


    private String generateRandomAlphameric(int length) {
        //对于 generateRandomAlphameric(int length) 函数，如果 length 小于 0 或者等于 0，这个函数应该返回什么？
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z'; //'Z'=90 'z'=122
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) (randomAscii);
                ++count;
            }
        }
        return new String(randomChars);
    }
}
/*
//代码使用举例
LogTraceIdGenerator logTraceIdGenerator = new RandomIdGenerator();*/
