package com.zzqf.spider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestSpider {

    String regex = "";

    public static void main(String[] args) {
        String context = HttpRequestUtils.httpGet("http://www.hhyungu.com/0-61-6-0-0-0-0---0-0-0.html", 6000);

        Pattern p = Pattern.compile("<li class='item fl'>[\\S\\s]*?class='pro-img fl b1' href='([\\S\\s]*?)'>[\\S\\s]*?</li>");
        Matcher m = p.matcher(context);
        System.out.println(m.groupCount());
        while(m.find()){
            String li = m.group(1);
            System.out.println("=======================================================");
            System.out.println(li);
        }
    }

}
