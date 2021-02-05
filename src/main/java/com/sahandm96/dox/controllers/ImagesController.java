package com.sahandm96.dox.controllers;

import com.sahandm96.dox.domain.dto.ImageDTO;
import com.sahandm96.dox.payload.response.RestMessages;
import com.sahandm96.dox.services.ImagesServices;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/v1")
public class ImagesController {

    private final ImagesServices imagesServices;

    public ImagesController(ImagesServices imagesServices) {
        this.imagesServices = imagesServices;

    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER') or hasRole('MANAGER') or hasRole('DeliveryGay')")
    @PostMapping({"/addPic"})
    public RestMessages addPic(@RequestBody ImageDTO img) {
        try {
            return this.imagesServices.addImages(img.getImg());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("it's out");
        return new RestMessages().NotFoundMessage("Error Happened");
    }
}
