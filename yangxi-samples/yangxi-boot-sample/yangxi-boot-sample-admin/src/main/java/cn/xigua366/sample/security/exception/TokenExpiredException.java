package cn.xigua366.sample.security.exception;

/**
 * <p>
 * 令牌过期异常
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
public class TokenExpiredException extends RuntimeException {

    public TokenExpiredException() {
    }

    public TokenExpiredException(String message) {
        super(message);
    }

    public TokenExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenExpiredException(Throwable cause) {
        super(cause);
    }

    public TokenExpiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}