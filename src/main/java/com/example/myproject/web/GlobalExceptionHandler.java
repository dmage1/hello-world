package com.example.myproject.web;

import com.example.myproject.domain.ExceptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handle Exceptions.
     *
     * @param ex the exception to handle
     * @return the SpeechstormResponse
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse handleExceptions(final Exception ex) {
        LOG.warn(ex.getMessage());
        return new ExceptionResponse(createSimplifiedMessage(ex));
    }

    /**
     * Creates a simplified message from any exception. Avoids appending class
     * name(s) of container exceptions by digging down to orignal exception. If
     * original exception doesn't include a message, the class name is used
     * instead.
     *
     * @param throwable the exception to extract the message from
     * @return a simplified message for this exception
     */
    protected static String createSimplifiedMessage(final Throwable throwable) {
        return getRootCause(throwable).getMessage() != null ? getRootCause(throwable).getMessage() : getRootCause(throwable).toString();
    }

    /**
     * Returning a list of class names in our XML is ugly...
     *
     * @param throwable the top-level throwable exception to set
     * @return the original exception
     */
    private static Throwable getRootCause(final Throwable throwable) {
        return throwable.getCause() != null ? getRootCause(throwable.getCause()) : throwable;
    }

}
