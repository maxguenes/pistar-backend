package com.pistar.filter;

import com.pistar.utils.XSSUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.regex.Pattern;

/**
 * Created by maxguenes on 19/07/2017.
 */
public class XSSRequestWrapper extends HttpServletRequestWrapper {

    public XSSRequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }

    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        if (values == null) {
            return null;
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = XSSUtils.stripXSS(values[i]);
        }
        return encodedValues;
    }

    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        if (value == null) {
            return null;
        }
        return XSSUtils.stripXSS(value);
    }

    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value == null)
            return null;
        return XSSUtils.stripXSS(value);
    }



}
