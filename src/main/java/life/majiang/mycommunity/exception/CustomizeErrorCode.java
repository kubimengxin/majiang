package life.majiang.mycommunity.exception;

/**
 * @author 苦逼萌新
 * @date 4/11/2020
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND("你找的问题不存在了，要不要换个试试？");
    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
