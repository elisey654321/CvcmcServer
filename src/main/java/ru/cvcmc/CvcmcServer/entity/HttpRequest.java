package ru.cvcmc.CvcmcServer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HttpRequest {

    private Object data;
    private Details details;

    public HttpRequest(Object data, int code) {
        this.data = data;
        this.details = new Details(code);
    }

    public HttpRequest(Object data, int code, String message) {
        this.data = data;
        this.details = new Details(code,message,message);
    }
}
