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

        String sss = "<p style=\"white-space: normal;\"><img src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/66d997af-f76b-40a5-98a6-f1c8846142d6.png&name=1.png\" " +
                "_src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/66d997af-f76b-40a5-98a6-f1c8846142d6.png&name=1.png\"/></p><p style=\"white-space: normal;\"><img " +
                "src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/4487e025-93d7-4944-9cb8-dbda4fdd03e6.png&name=2.png\" " +
                "_src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/4487e025-93d7-4944-9cb8-dbda4fdd03e6.png&name=2.png\"/></p><p style=\"white-space: normal;\"><img " +
                "src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/c47af05d-16d8-41e0-a398-1612fd49d03c.png&name=3.png\" " +
                "_src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/c47af05d-16d8-41e0-a398-1612fd49d03c.png&name=3.png\"/></p><p style=\"white-space: normal;\"><img " +
                "src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/53e8e9c8-72e7-4ba7-bf32-59b6c3640f23.png&name=4.png\" " +
                "_src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/53e8e9c8-72e7-4ba7-bf32-59b6c3640f23.png&name=4.png\"/></p><p style=\"white-space: normal;\"><img " +
                "src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/6977237c-9e0f-4d28-9540-08c1ff743d76.png&name=5.png\" " +
                "_src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/6977237c-9e0f-4d28-9540-08c1ff743d76.png&name=5.png\"/></p><p style=\"white-space: normal;\"><img " +
                "src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/09b2a494-953b-4f12-ba14-b29c36ad0ce0.png&name=6.png\" " +
                "_src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/09b2a494-953b-4f12-ba14-b29c36ad0ce0.png&name=6.png\"/></p><p style=\"white-space: normal;\"><img " +
                "src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/dcc9a966-46f1-40f5-a1b3-7addebf35a69.png&name=9.png\" " +
                "_src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/dcc9a966-46f1-40f5-a1b3-7addebf35a69.png&name=9.png\"/></p><p style=\"white-space: normal;\"><img " +
                "src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/df47dbf7-1b21-4f0d-a934-f74d90e645c3.png&name=10.png\" " +
                "_src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/df47dbf7-1b21-4f0d-a934-f74d90e645c3.png&name=10.png\"/></p><p style=\"white-space: normal;\"><img " +
                "src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/9c584ce6-948f-4b59-b38c-5c17adc8b7f1.png&name=11.png\" " +
                "_src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/9c584ce6-948f-4b59-b38c-5c17adc8b7f1.png&name=11.png\"/></p><p style=\"white-space: normal;\"><img " +
                "src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/dec06783-9b47-4970-80d4-f3bc90dfbff0.png&name=13.png\" " +
                "_src=\"http://r8-test.realtour.com.cn//PublicPage/Webload.aspx" +
                "?fileType=PublicFiles&path=OA/Umeditor/2018/10/16/dec06783-9b47-4970-80d4-f3bc90dfbff0.png&name=13.png\"/></p><p><br/></p>";
        //String s = "撒的发生的手动阀http://www.baidu.com阿斯顿发送到";
        //String s = "开始大发送到https://www.cnblogs.com/akiradunn/p/5855073.html大发送到http://www.tngou.net/blog/show/496大发送到结束http://www.baidu.com/daf";
//        String s = "博客地址:http://blog.csdn.net/u013456370页面初始化赋值：http://blog.csdn.net/u013456370/article/details/68067469";
        //String mode = "<a\\s*href=(?='?http|https)([^>]*)title=([^>]*)>(.*?)</a>";
        //String mode = "https?://\\w+\\.\\w+\\.\\w+";
        //String mode = "[a-zA-z]+://[^\\s]*+[a-zA-z]";
        String mode = "src=\"http[s]?://([\\w-.]+)([\\w-:/.]+)\\??([\\w-./%&*=]*)";
//        String mode = "src=\"http[s]?://([\\w-]+\\.)+[\\w-]+([\\w-./?%&*=]*)";
        Pattern pattern = Pattern.compile(mode);
        Matcher matcher = pattern.matcher(sss);
        StringBuilder objectName = new StringBuilder();
        String mo = "http[s]?://[\\w-.]+[\\w-:]+";
        String requestURL = "http://qjb2b-api.realtour-test.com.cn/file/downFile";
//        String requestURL = "http://webapi.realtour-develop.cn:8088/file/downFile";
        Pattern b2bPattern = Pattern.compile(mo);
        Matcher b2bMatcher = b2bPattern.matcher(requestURL);
        if (b2bMatcher.find()) {
            String domain = b2bMatcher.group(0);
            String s1 = objectName.toString();
            objectName.delete(0, objectName.length());
            // http://webapi.realtour-develop.cn:8088/file/downFile?
            // loginMode=Front&objectName=PublicFiles%2FSystem%2FSight%2F2018%2F10%2F16%2Fbb054769-f8fa-4cf7-89b5-9dd632debfeb.png
            objectName.append("src=\"").append(domain).append("/file/downFile?loginMode=Front&objectName=")
                    .append(s1);
        }
        while (matcher.find()) {
            String url = matcher.group(0);
            System.out.println("url = " + url);
            String param = matcher.group(1);
            System.out.println("param = " + param);
            String param2 = matcher.group(2);
            System.out.println("param = " + param2);
            String param3 = matcher.group(3);
            System.out.println("param = " + param3);
//            String param4 = matcher.group(4);
//            System.out.println("param = " + param4);
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
        }
        //System.out.println("最后替换的：" + s1);
    }
}
