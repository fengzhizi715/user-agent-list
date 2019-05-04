package cn.netdiscovery.ualist;

import cn.netdiscovery.core.domain.Page;
import cn.netdiscovery.core.parser.AnnotationParser;
import cn.netdiscovery.core.parser.annotation.ExtractBy;
import cn.netdiscovery.core.utils.URLParser;

import java.io.UnsupportedEncodingException;
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
