package cn.willow.demo.framework;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Willow on 5/2/17.
 */
public class Cgi {
    private HttpServletRequest req;
    private HttpServletResponse rep;

    public Cgi(HttpServletRequest request, HttpServletResponse response) {
        this.req = request;
        this.rep = response;
    }

    public HttpServletRequest getRequest() {
        return req;
    }

    public void setRequest(HttpServletRequest request) {
        this.req = request;
    }

    public HttpServletResponse getResponse() {
        return rep;
    }

    public void setResponse(HttpServletResponse response) {
        this.rep = response;
    }

    public HttpSession getSession() {
        return this.req.getSession();
    }


    public String getString(String key, String defaultValue) {
        String value = req.getParameter(key);
        if (StringUtils.isEmpty(value))
            return defaultValue;
        return value;
    }
}
