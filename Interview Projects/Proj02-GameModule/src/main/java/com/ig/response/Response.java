package com.ig.response;
public record Response<T>(String status, String message, T data){}
