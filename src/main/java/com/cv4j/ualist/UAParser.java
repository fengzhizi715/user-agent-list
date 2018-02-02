package com.cv4j.ualist;

import com.cv4j.netdiscovery.core.domain.Page;
import com.cv4j.netdiscovery.core.domain.ResultItems;
import com.cv4j.netdiscovery.core.parser.Parser;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by tony on 2018/2/2.
 */
public class UAParser implements Parser {

    @Override
    public void process(Page page) {

        ResultItems resultItems = page.getResultItems();

        resultItems.put("ua",page.getHtml().xpath("//div[@id='liste']/ul/li/a/text()").all());

        URL url = null;
        try {
            url = new URL( page.getUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        resultItems.put("fileName",url.getQuery().substring(5));
    }
}
