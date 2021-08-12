package com.nn.basket.exception;

import lombok.Generated;

/**
 * This is the Custom Exception class
 *
 * @author Revathi
 */
public class BasketHttpException extends RuntimeException {
    /**
     * field httpStatus
     */
    private final int httpStatus;

    /**
     * Constuctor Instatiation with exception Message and Httpstatus
     *
     * @param message    exception Message
     * @param httpStatus 401/404/500
     */
    private BasketHttpException(String message, int httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    /**
     * Forms the Internal server error exception
     *
     * @param message exception Message
     * @return exception
     */
    public static BasketHttpException serverError(String message) {
        return new BasketHttpException(message, 500);
    }

    /**
     * Forms the Bad Request exception
     *
     * @param message exception Message
     * @return exception
     */
    public static BasketHttpException badRequest(String message) {
        return new BasketHttpException(message, 400);
    }

    /**
     * Forms the Unauthorised Exception
     *
     * @param message exception Message
     * @return exception
     */
    public static BasketHttpException unAuthorized(String message) {
        return new BasketHttpException(message, 401);
    }

    /**
     * Forms the Not Found Exception
     *
     * @param message exception Message
     * @return exception
     */
    public static BasketHttpException notFound(String message) {
        return new BasketHttpException(message, 404);
    }

    @Generated
    public int getHttpStatus() {
        return this.httpStatus;
    }
}
