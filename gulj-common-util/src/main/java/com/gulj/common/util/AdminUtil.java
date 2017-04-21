package com.gulj.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author gulj
 * @create 2017-04-21 下午6:53
 **/
public class AdminUtil {

    private final static Logger logger = LoggerFactory.getLogger(AdminUtil.class);

    /**
     * 请求头中的设备信息，格式为：deviceType<>device
     */
    public static final String API_DEVICE_INFO = "-di-";

    public static final String API_DEVICE_INFO_SEPARATOR = "<>";

    private AdminUtil() {
    }

    public static void writeJson(HttpServletResponse rsp, Map<String, Object> map) {
        rsp.setCharacterEncoding("UTF-8");
        rsp.setContentType("text/html");
        try {
            rsp.getWriter().print(JsonUtil.map2Json(map));
            rsp.flushBuffer();
        } catch (IOException e) {
            logger.error("@@@@写出json出现异常", e);
        }
    }

    /**
     * 对Map进行key的升序排序
     *
     * @param map
     * @return
     */
    public static LinkedHashMap<String, Object> sortMapByKey(Map<String, Object> map) {
        if (map.isEmpty()) {
            return null;
        }
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        LinkedHashMap<String, Object> lm = new LinkedHashMap<>();
        for (int i = 0; i < keys.length; i++) {
            lm.put(keys[i].toString(), map.get(keys[i]));
        }
        return lm;
    }

    /**
     * 对mapkey进行升序排序，并对 数组value进行拼接
     *
     * @param params
     * @return
     */
    public static Map<String, String> sortAndJoinParamValues(Map<String, String[]> params) {
        if (params.isEmpty()) {
            return null;
        }
        Object[] keys = params.keySet().toArray();
        Arrays.sort(keys);
        LinkedHashMap<String, String> lm = new LinkedHashMap<>();
        for (int i = 0; i < keys.length; i++) {
            String k = keys[i].toString();
            lm.put(k, String.join(",", params.get(k)));
        }
        return lm;
    }

    /**
     * 对arr进行升序排序，并对 数组value进行拼接
     *
     * @param params
     * @return
     */
    public static String sortAndJoinArr(String[] params) {
        if (params.length == 0) {
            return "";
        }
        Arrays.sort(params);
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < params.length; i++) {
            b.append(params[i].toString());
        }
        return b.toString();
    }

    /**
     * 从cookie中获取 _e_ 的值
     *
     * @param req
     * @return
     */
    public static String getE(HttpServletRequest req) {
        Cookie[] cs = req.getCookies();
        if (cs != null && cs.length > 0) {
            for (Cookie c : cs) {
                if (c.getName().equals("_e_")) {
                    return c.getValue();
                }
            }
        }
        return null;
    }

    public static boolean isAjaxReq(HttpServletRequest req) {
        return "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));
    }

    public static void setAuthCookie(String key, String value, HttpServletResponse resp) {
        Cookie c = new Cookie(key, value);
        c.setPath("/");
        c.setMaxAge(60 * 60 * 24 * 365);
        resp.addCookie(c);
    }

    /**
     * 根据User-Agent，判断当前请求，是否在微信中发起
     *
     * @param req
     * @return
     */
    public static boolean isInWX(HttpServletRequest req) {
        String ua = req.getHeader("User-Agent");
        if (StringUtils.hasText(ua) && ua.toLowerCase().indexOf("micromessenger") != -1) {
            return true;
        }
        return false;
    }


    public static String stripXSS(String value) {
        String cleanValue = null;
        if (value != null) {
            cleanValue = Normalizer.normalize(value, Normalizer.Form.NFD);

            // Avoid null characters
            cleanValue = cleanValue.replaceAll("\0", "");

            // Avoid anything between script tags
            Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Avoid anything in a src='...' type of expression
            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Remove any lonesome </script> tag
            scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Remove any lonesome <script ...> tag
            scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Avoid eval(...) expressions
            scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Avoid expression(...) expressions
            scriptPattern = Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Avoid javascript:... expressions
            scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Avoid vbscript:... expressions
            scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

            // Avoid onload= expressions
            scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");
        }
        return cleanValue;
    }


}
