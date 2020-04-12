package life.majiang.mycommunity.exception;

/**
 * @author 苦逼萌新
 * @date 4/11/2020
 */
public class CustomizeException extends RuntimeException {
    private String message;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
