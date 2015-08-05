package com.bin.spring.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileRestfulController {
	
	@RequestMapping("/file")
	public ResponseEntity<byte[]> getFile(HttpServletRequest request) throws IOException {
	    InputStream in = request.getServletContext().getResourceAsStream("/images/marker.jpg");

	    final HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG);

	    return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value={"/filebytearray"})
    public @ResponseBody byte[] getFileByteArray(HttpServletRequest request) throws IOException {
		 
        InputStream is = request.getServletContext().getResourceAsStream("/images/marker.jpg");

        BufferedImage img = ImageIO.read(is);

        ByteArrayOutputStream bao = new ByteArrayOutputStream();

        ImageIO.write(img, "jpg", bao);

        return bao.toByteArray();
    }
	
}
