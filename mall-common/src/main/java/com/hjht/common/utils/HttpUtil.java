package com.hjht.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.MapUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @Date 2020/4/19 11:06
 * @Created by ycl
 * 基于apache HttpClient对http请求封装
 */
@Component
public class HttpUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    private static HttpClient httpClient;

    static {
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(10000).setSocketTimeout(30000).build();
        HttpClientBuilder builder = HttpClientBuilder.create().setDefaultRequestConfig(config).setRetryHandler(new DefaultHttpRequestRetryHandler(3, false));
        httpClient = builder.build();
    }


    /**
     * 发送get请求
     * @param url
     * @param params
     * @return
     */
    public static String getByJson(String url, Map<String,Object> params){
        StringBuilder sb = new StringBuilder(url);
        if (MapUtils.isNotEmpty(params)) {
            params.forEach((k, v) -> {
                if (sb.toString().contains("?")) {
                    sb.append("&").append(k).append("=").append(v);
                } else {
                    sb.append("?").append(k).append("=").append(v);
                }
            });
        }
        HttpGet httpGet = new HttpGet(sb.toString());
        httpGet.setHeader("Content-Type", "application/json");
        try {
            HttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() != 500) {
                HttpEntity entity = response.getEntity();
                String str = EntityUtils.toString(entity, "UTF-8");
                return str;
            }
        } catch (ClientProtocolException var7) {
            var7.printStackTrace();
        } catch (IOException var8) {
            var8.printStackTrace();
        }
        return null;
    }

    /**
     * post请求，head和body分开设置
     * @param header
     * @param url
     * @param data
     * @return
     */
    public static String postByJson(Map<String, Object> header, String url, Object data) {
        logger.info("[postByJson] url:{}", url);
        HttpPost httpPost = new HttpPost(url);
        if (MapUtils.isNotEmpty(header)) {
            header.forEach((k, v) -> {
                httpPost.setHeader(k, String.valueOf(v));
            });
        }
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        String charSet = "UTF-8";
        String format;
        if (data instanceof String) {
            format = String.valueOf(data);
        } else {
            format = JSONObject.toJSONString(data);
        }
        StringEntity stringEntity = new StringEntity(format, charSet);
        httpPost.setEntity(stringEntity);
        try {
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() != 500) {
                HttpEntity entity = response.getEntity();
                String str = EntityUtils.toString(entity, "UTF-8");
                return str;
            }
            throw new RuntimeException("");
        } catch (UnsupportedEncodingException var10) {
            var10.printStackTrace();
        } catch (ClientProtocolException var11) {
            var11.printStackTrace();
        } catch (IOException var12) {
            var12.printStackTrace();
        } catch (Exception var13) {
            var13.printStackTrace();
        }
        return null;
    }

    /**
     * post请求，head和body一起设置
     * @param url
     * @param data
     * @return
     */
    public static String postByJson(String url, Object data) {
        logger.info("[postByJson] url:{}", url);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        String charSet = "UTF-8";
        String format;
        if (data instanceof String) {
            format = String.valueOf(data);
        } else {
            format = JSONObject.toJSONString(data);
        }
        StringEntity stringEntity = new StringEntity(format, charSet);
        httpPost.setEntity(stringEntity);
        try {
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() != 500) {
                HttpEntity entity = response.getEntity();
                String str = EntityUtils.toString(entity, "UTF-8");
                return str;
            }
            throw new RuntimeException("");
        } catch (UnsupportedEncodingException var9) {
            var9.printStackTrace();
        } catch (ClientProtocolException var10) {
            var10.printStackTrace();
        } catch (IOException var11) {
            var11.printStackTrace();
        } catch (Exception var12) {
            var12.printStackTrace();
        }
        return null;
    }
}
