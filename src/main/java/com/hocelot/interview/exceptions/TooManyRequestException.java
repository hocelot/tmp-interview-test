package com.hocelot.interview.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
public class TooManyRequestException { /* extends BaseException {

    public TooManyRequestException(ErrorEnum e) {
        super(e);
    }

    public TooManyRequestException(String message, ErrorEnum e) {
        super(message, e);
    }

    public TooManyRequestException(String message, Throwable cause, ErrorEnum e) {
        super(message, cause, e);
    }
*/
}
