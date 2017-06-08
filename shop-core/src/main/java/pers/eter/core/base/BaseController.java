package pers.eter.core.base;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import pers.eter.core.constant.Constant;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Eter on 17-6-7.
 */
public class BaseController {

    @ModelAttribute
    protected void preMethod(HttpServletRequest request, Model model) {
        String ctx = request.getContextPath();
        model.addAttribute("ctx", ctx);
    }

    protected ResultInfo success(Object result) {
        ResultInfo resultInfo = new ResultInfo();

        resultInfo.setResult(result);
        resultInfo.setResultCode(Constant.SUCCESS_CODE);
        resultInfo.setResultMessage(Constant.SUCCESS_MSG);

        return resultInfo;
    }

    protected ResultInfo failure(int coude, String errorMessage) {
        ResultInfo resultInfo = new ResultInfo();

        resultInfo.setResultCode(coude);
        resultInfo.setResultMessage(errorMessage);

        return resultInfo;
    }
}
