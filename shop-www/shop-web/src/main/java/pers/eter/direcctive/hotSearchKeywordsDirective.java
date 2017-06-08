package pers.eter.direcctive;

import com.alibaba.fastjson.JSON;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Eter on 17-6-8.
 */
@Component
public class hotSearchKeywordsDirective implements TemplateDirectiveModel{
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        List<String> kewords = new ArrayList<>();
        kewords.add("三星");
        kewords.add("苹果");

        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        if (null != body) {
            TemplateModel result = beansWrapper.wrap(kewords);
            env.setVariable("keywords", result);
            body.render(env.getOut());
        } else {
            env.getOut().write(JSON.toJSONString(kewords));
        }
    }
}
