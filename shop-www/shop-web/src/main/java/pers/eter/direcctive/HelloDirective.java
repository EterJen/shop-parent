package pers.eter.direcctive;

import com.alibaba.fastjson.JSON;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Eter on 17-6-6.
 */
public class HelloDirective  implements TemplateDirectiveModel{
    private static Logger logger = LoggerFactory.getLogger(HelloDirective.class);

    private static final BeansWrapper BEANS_WRAPPER = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        logger.debug("接受参数--->{}",params);

        params.put("param", "程序内部注入");
        TemplateModel templateModel = BEANS_WRAPPER.wrap(params);
        env.setVariable("params", templateModel);

        if (body != null) {
            body.render(env.getOut());
        }else {
            env.getOut().write(JSON.toJSONString(params));
        }
    }

}
