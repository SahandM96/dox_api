package com.sahandm96.dox.services;

import com.sahandm96.dox.payload.response.RestMessages;

import java.io.IOException;


public interface ImagesServices {
    RestMessages addImages(String img) throws IOException;
//    String addImages(String img) throws IOException;

}
