package com.fairhaven.web.interceptors;


// Import log4j class
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 *
 * @author Sam
 */

@Component
public class LoggingInterceptor implements WebRequestInterceptor {

    private static final Logger logger = Logger.getLogger(LoggingInterceptor.class.getName());

    private LocalDateTime requestStartTime, requestCompletionTime;
    private String requestedUrl;
    
    @Override
    public void preHandle(WebRequest wr) throws Exception {
        requestStartTime = LocalDateTime.now();
        requestedUrl = wr.getDescription(false);
        logger.info("Requested " + requestedUrl + " at " + requestStartTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    @Override
    public void postHandle(WebRequest wr, ModelMap mm) throws Exception {
        requestCompletionTime = LocalDateTime.now();
        long requestDuration = Duration.between(requestStartTime, requestCompletionTime).toMillis();
        logger.info("Request to " + requestedUrl + " completed in " + requestDuration + " ms");
    }

    @Override
    public void afterCompletion(WebRequest wr, Exception excptn) throws Exception {
       
    }
}
