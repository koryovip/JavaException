package ex;

import java.text.MessageFormat;

import ex.annotation.ExceptionMessage;
import ex.base.BizException;

final class BL001Exceptions extends BizException {

    static final private Class<BL001Exceptions> clazz = BL001Exceptions.class;
    static final String id = "BL001";

    public BL001Exceptions(String exceptionId) {
        super(exceptionId);
    }

    @ExceptionMessage("")
    static public String E001(String value) {
        return MessageFormat.format("ユーザーID存在しない。{0}", value);
    }

    @ExceptionMessage("ユーザーID存在しない。{0}")
    static public BL001Exceptions E002(String value) {
        return new BL001Exceptions(ddd2(clazz, id, value));
    }

    @ExceptionMessage("{0} テーブルに存在しない。COMPANYCD={1}, USERID={2}")
    static public BL001Exceptions E003(String tableName, String companyCd, String userId) {
        return new BL001Exceptions(ddd2(clazz, id, tableName, companyCd, userId));
    }
}
