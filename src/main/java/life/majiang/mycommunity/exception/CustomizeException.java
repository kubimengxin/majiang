package life.majiang.mycommunity.exception;

/**
 * @author 苦逼萌新
 * @date 4/11/2020
 */
public class CustomizeException extends RuntimeException {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public CustomizeException(String message) {
        this.message = message;
    }
    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }
}
