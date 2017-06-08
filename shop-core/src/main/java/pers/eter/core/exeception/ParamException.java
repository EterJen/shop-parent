package pers.eter.core.exeception;

import pers.eter.core.constant.Constant;

/**
 * Created by Eter on 17-6-7.
 */
public class ParamException extends RuntimeException {
    private int resultCode;

    public ParamException(String resultMessage) {
        super(resultMessage);
        this.resultCode = Constant.ERROR_CODE;
    }

    public ParamException(int resultCode, String resultMessage) {
        super(resultMessage);
        this.resultCode = resultCode;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}
