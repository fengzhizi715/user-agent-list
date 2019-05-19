package cn.netdiscovery.ualist;

import cn.netdiscovery.core.domain.ResultItems;
import cn.netdiscovery.core.pipeline.Pipeline;
import cn.netdiscovery.core.vertx.VertxUtils;
import io.vertx.core.buffer.Buffer;

import java.util.List;

/**
 * Created by tony on 2018/2/2.
 */
public class FilePipeline extends Pipeline {

    @Override
    public void process(ResultItems resultItems) {

        List<String> uas = resultItems.get("ua");

        StringBuilder sb = new StringBuilder();
        uas.forEach(s->sb.append(s).append("\r\n"));

        String fileName = resultItems.get("fileName")+".txt";

        VertxUtils.getVertx().fileSystem().writeFile(fileName, Buffer.buffer(sb.toString()), result -> {

            if(result.succeeded()) {

                System.out.println("File written");
            }
        });
    }
}
