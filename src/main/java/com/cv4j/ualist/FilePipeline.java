package com.cv4j.ualist;

import com.cv4j.netdiscovery.core.domain.ResultItems;
import com.cv4j.netdiscovery.core.pipeline.Pipeline;
import com.cv4j.netdiscovery.core.utils.VertxUtils;
import io.vertx.core.buffer.Buffer;

import java.util.List;

/**
 * Created by tony on 2018/2/2.
 */
public class FilePipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems) {

        List<String> uas = resultItems.get("ua");

        StringBuilder sb = new StringBuilder();
        uas.forEach(s->sb.append(s).append("\r\n"));

        String fileName = resultItems.get("fileName")+".txt";

        VertxUtils.vertx.fileSystem().writeFile(fileName, Buffer.buffer(sb.toString()), result -> {

            if(result.succeeded()) {

                System.out.println("File written");
            }
        });
    }
}
