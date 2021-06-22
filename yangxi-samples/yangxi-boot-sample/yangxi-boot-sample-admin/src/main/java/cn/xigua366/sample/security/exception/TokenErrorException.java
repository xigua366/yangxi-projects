package cn.xigua366.sample.security.exception;

/**
 * <p>
 * 令牌错误异常
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
public class TokenErrorException extends RuntimeException {

    public TokenErrorException() {
    }

    public TokenErrorException(String message) {
        super(message);
    }

    public TokenErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenErrorException(Throwable cause) {
        super(cause);
    }

    public TokenErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}