package com.solidground.infra.web.resolver;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.ZoneOffset;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * @author fdanismaz
 * date: 10/29/18 1:59 PM
 */
@Slf4j
public class ContextResolver {

    public HttpServletRequest getRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        } catch (IllegalStateException e) {
            log.warn("Cannot access request object" + e.getMessage(), e);
            return null;
        }
    }

    public HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
    }

    public TimeZone getClientTimeZone() {
        var request = this.getRequest();
        if (request != null) {
            var timezoneHeader = request.getHeader("timezone");
            try {
                var timeZoneOffset = Integer.parseInt(timezoneHeader);
                ZoneOffset zoneOffset = ZoneOffset.ofTotalSeconds((int)TimeUnit.HOURS.toSeconds(-timeZoneOffset));
                return TimeZone.getTimeZone(zoneOffset);
            }
            catch (NumberFormatException e) {
                log.error("Cannot parse \'timezone\' header. Expected number..." + timezoneHeader);
            }
        }
        return TimeZone.getDefault();
    }
}
