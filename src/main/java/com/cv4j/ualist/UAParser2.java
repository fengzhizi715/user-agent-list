package com.cv4j.ualist;

import com.cv4j.netdiscovery.core.domain.Page;
import com.cv4j.netdiscovery.core.parser.AnnotationParser;
import com.cv4j.netdiscovery.core.parser.annotation.ExtractBy;
import com.cv4j.netdiscovery.core.utils.URLParser;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by tony on 2018/2/28.
 */
public class UAParser2 extends AnnotationParser {

    @ExtractBy.XPath("//div[@id='liste']/ul/li/a/text()")
    private List<String> ua;

    @Override
    public void process(Page page) {
        super.process(page);

        URLParser parser = page.getRequest().getUrlParser();

        try {
            resultItems.put("fileName",parser.getParam("name"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
