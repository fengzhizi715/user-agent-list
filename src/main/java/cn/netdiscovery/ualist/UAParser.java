package cn.netdiscovery.ualist;


import cn.netdiscovery.core.domain.Page;
import cn.netdiscovery.core.domain.ResultItems;
import cn.netdiscovery.core.parser.Parser;
import cn.netdiscovery.core.utils.URLParser;

import java.io.UnsupportedEncodingException;

/**
 * Created by tony on 2018/2/2.
 */
public class UAParser implements Parser {

    @Override
    public void process(Page page) {

        ResultItems resultItems = page.getResultItems();

        resultItems.put("ua",page.getHtml().xpath("//div[@id='liste']/ul/li/a/text()").all());

        URLParser parser = page.getRequest().getUrlParser();

        try {
            resultItems.put("fileName",parser.getParam("name"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
