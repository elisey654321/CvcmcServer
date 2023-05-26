package ru.cvcmc.CvcmcServer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Details {

    private int code;
    private String message;
    private String description;

    public Details(int code) {
        this.code = code;
    }
}
