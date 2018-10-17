package com.example.tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author c
 */
public class Main {
    public static void main(String[] args) {
        // 截取网页中的链接中的TITLE和URL，且URL必须以HTTP或HTTPS开头
        String s = "<div><img src=\"http://webapi.realtour-develop.cn:8099/file/downFile" +
                "?fileType=PublicFiles" +
                "&path=%2FSystem%2FSight%2F2018%2F10%2F16%2Fbb054769-f8fa-4cf7-89b5-9dd632debfeb.png&name= " +
                "title='tip'>aaa</img><a src=\"https://www.baidu.com?fileType=PublicFiles&path=%2FSyste" +
                "title='baiduSearch'>bbb</a><span><a src=\"http://blog.csdn.net/u013456370/article/details/68067469\">ccc</a></span></div>";
        //String s = "撒的发生的手动阀http://www.baidu.com阿斯顿发送到";
        //String s = "开始大发送到https://www.cnblogs.com/akiradunn/p/5855073.html大发送到http://www.tngou.net/blog/show/496大发送到结束http://www.baidu.com/daf";
//        String s = "博客地址:http://blog.csdn.net/u013456370页面初始化赋值：http://blog.csdn.net/u013456370/article/details/68067469";
        //String mode = "<a\\s*href=(?='?http|https)([^>]*)title=([^>]*)>(.*?)</a>";
        //String mode = "https?://\\w+\\.\\w+\\.\\w+";
        //String mode = "[a-zA-z]+://[^\\s]*+[a-zA-z]";
        String mode = "src=\"http[s]?://[\\w-.]+[\\w-:/]+\\??([\\w-./%&*=]*)";
//        String mode = "src=\"http[s]?://([\\w-]+\\.)+[\\w-]+([\\w-./?%&*=]*)";
        Pattern pattern = Pattern.compile(mode);
        Matcher matcher = pattern.matcher(s);
        StringBuilder objectName = new StringBuilder();
        String mo = "http[s]?://[\\w-.]+[\\w-:]+";
        String requestURL = "http://webapi.realtour-develop.cn:8088/file/downFile";
        Pattern b2bPattern = Pattern.compile(mo);
        Matcher b2bMatcher = b2bPattern.matcher(requestURL);
        while (matcher.find()) {
            String url = matcher.group(0);
            String param = matcher.group(1);
            String[] split = param.split("&");
            objectName.delete(0, objectName.length());
            for (String s1 : split) {
                String[] split1 = s1.split("=");
                if ("fileType".equalsIgnoreCase(split1[0])) {
                    objectName.append(split1[1]);
                } else if ("path".equalsIgnoreCase(split1[0])) {
                    objectName.append(split1[1]);
                }
            }
            if (objectName.length() > 0) {

                if (b2bMatcher.find()) {
                    String domain = b2bMatcher.group(0);
                    String s1 = objectName.toString();
                    objectName.delete(0, objectName.length());
                    // http://webapi.realtour-develop.cn:8088/file/downFile?
                    // loginMode=Front&objectName=PublicFiles%2FSystem%2FSight%2F2018%2F10%2F16%2Fbb054769-f8fa-4cf7-89b5-9dd632debfeb.png
                    objectName.append("src=\"").append(domain).append("/file/downFile?loginMode=Front&objectName=")
                            .append(s1);
                    s = s.replace(url, objectName.toString());
                    System.out.println(s);
                }
            }
        }
        //System.out.println("最后替换的：" + s1);
    }
}
