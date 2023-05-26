package ru.cvcmc.CvcmcServer.service;

import ru.cvcmc.CvcmcServer.entity.HttpRequest;

public class HttpRequestService {

    public static HttpRequest createHttpRequest(Object data,int code){
        return new HttpRequest(data,code);
    }

    public static HttpRequest createHttpRequest(Object data,int code, String message){
        return new HttpRequest(data,code,message);
    }

}
