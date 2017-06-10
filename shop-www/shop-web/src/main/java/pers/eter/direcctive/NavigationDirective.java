package pers.eter.direcctive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.stereotype.Component;
import pers.eter.core.model.Navigation;
import pers.eter.service.NavigationService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Eter on 17-6-8.
 */
@Component
public class NavigationDirective extends BaseDirective {
    @Resource
    private NavigationService navigationService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        /*取参*/
       /* TemplateModel positionTM = (TemplateModel) params.get("position");
        BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_21).build();
        Integer position = (Integer) beansWrapper.unwrap(positionTM, Integer.class);*/
        Integer position = getParameter(params, "position", Integer.class);

        /*	// 调用service方法获取数据
        List<Navigation> navigations = navigationService.find(position);
		// 输出
		if (body != null) {
			TemplateModel result = beansWrapper.wrap(navigations); // 将Java对象转化为freemarker的模板模型
			env.setVariable("navigations", result); // 设置输出的key
			// 输出
			body.render(env.getOut());
		} else {
			 env.getOut().write(JSON.toJSONString(navigations)); // 输出json
		}*/
        List<Navigation> navigations = navigationService.find(position);

        /*处理并返回freemarker类型数据*/
       /*
        if (null != body) {
            TemplateModel templateModel = beansWrapper.wrap(navigations);
            env.setVariable("navigations", templateModel);
            body.render(env.getOut());
        } else {
            env.getOut().write(JSON.toJSONString(navigations));
        }


*/

        setVariable(env, body, "navigations", navigations);


    }
}
