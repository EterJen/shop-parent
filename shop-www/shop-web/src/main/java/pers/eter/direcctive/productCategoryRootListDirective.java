package pers.eter.direcctive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.stereotype.Component;
import pers.eter.core.vo.ProductCateGoryVo;
import pers.eter.service.ProductCategoryService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Eter on 17-6-9.
 */
@Component
public class productCategoryRootListDirective extends BaseDirective {
    @Resource
    private ProductCategoryService productCategoryService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        Integer count = getParameter(params, "count", Integer.class);
        List<ProductCateGoryVo> productCateGoryVos = productCategoryService.findBootList(count);
        setVariable(env, body, "productCategories", productCateGoryVos);

    }
}
