package com.wenyiguai.keepl.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class HttpUtils {

    public static String post(String url, Object data){
        try{

            String requestUrl = "";
//            HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
//            requestFactory.setConnectTimeout(5000);
            String jsonBody = "{\"data\":\""+ data + "\"}";
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");
            headers.setContentType(type);
//            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();  //请求体，键值对
//            params.add("IdCode","");
//            params.add("Appid", appid);
//            params.add("sign",sign);
            HttpEntity<String> formEntity = new HttpEntity<String>(jsonBody, headers);
//            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
            String response = restTemplate.postForObject(url, formEntity, String.class);
            return response;

//            MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");//
//            HttpEntity<String> formEntity = new HttpEntity<String>(jsonBody, headers);
//            logger.info("MessageNotify:url:"+ url + "  requestBody:" + requestEntity + " Response:" + response);
        }catch ( Exception e){
            e.printStackTrace();
//            logger.info(e.getMessage());
        }
        return null;
    }

}
