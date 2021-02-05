package com.sahandm96.dox.services;

import com.sahandm96.dox.domain.Images;
import com.sahandm96.dox.payload.response.MessageResponse;
import com.sahandm96.dox.payload.response.RestMessages;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class ImagesServicesImpl implements ImagesServices {

    private static final Set<PosixFilePermission> filePermissions = Stream.of(
            PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_WRITE, PosixFilePermission.GROUP_EXECUTE,
            PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE, PosixFilePermission.OWNER_EXECUTE,
            PosixFilePermission.OTHERS_READ, PosixFilePermission.OTHERS_WRITE, PosixFilePermission.OTHERS_EXECUTE
    ).collect(Collectors.toCollection(HashSet::new));

    @Override
    public RestMessages addImages(String img) {
        img = img.replaceAll(" ", "+");
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String partSeparator = ",";
        if (img.contains(partSeparator)) {
            img = img.split(partSeparator)[1];
        }
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] imageByte = decoder.decode(img.getBytes(StandardCharsets.UTF_8));
        try (ByteArrayInputStream bis = new ByteArrayInputStream(imageByte)) {
            BufferedImage image = ImageIO.read(bis);
            File outputFile = new File("/home/sahandm96/Music/" + uuid + ".jpg");
            ImageIO.write(image, "jpg", outputFile);
            Files.setPosixFilePermissions(outputFile.toPath(), filePermissions);
            return new RestMessages("Image Saved", "200", uuid);

        } catch (IOException e) {
            System.out.println("id ==>" + uuid);
            return new RestMessages().NotFoundMessage(e.getMessage());
        }

    }

}
