package cn.netdiscovery.ualist;


import cn.netdiscovery.core.domain.Page;
import cn.netdiscovery.core.domain.ResultItems;
import cn.netdiscovery.core.parser.Parser;

import java.io.UnsupportedEncodingException;

/**
 * Created by tony on 2018/2/2.
 */
public class UAParser implements Parser {

    @Override
    public void process(Page page) {

        ResultItems resultItems = page.getResultItems();

        resultItems.put("ua", page.getHtml().xpath("//div[@id='liste']/ul/li/a/text()").all());   // 获取 ua 的内容

        try {
            resultItems.put("fileName", page.getRequest().getUrlParser().getParam("name")); // 获取文件的名称
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
