package com.cv4j.ualist;

import com.cv4j.netdiscovery.core.Spider;

/**
 * Created by tony on 2018/2/2.
 */
public class Main {

    public static void main(String[] args) {

        Spider.create()
                .name("tony")
                .url("http://www.useragentstring.com/pages/useragentstring.php?name=Googlebot")
                .url("http://www.useragentstring.com/pages/useragentstring.php?name=Baiduspider")
                .url("http://www.useragentstring.com/pages/useragentstring.php?name=Chrome")
                .url("http://www.useragentstring.com/pages/useragentstring.php?name=Firefox")
                .url("http://www.useragentstring.com/pages/useragentstring.php?name=Mozilla")
                .url("http://www.useragentstring.com/pages/useragentstring.php?name=Opera")
                .url("http://www.useragentstring.com/pages/useragentstring.php?name=Safari")
                .url("http://www.useragentstring.com/pages/useragentstring.php?name=Edge")
                .parser(new UAParser())
                .pipeline(new FilePipeline())
                .run();
    }
}
