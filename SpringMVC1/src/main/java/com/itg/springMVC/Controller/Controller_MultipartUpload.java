package com.itg.springMVC.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URLEncoder;

@Controller
public class Controller_MultipartUpload {
    @RequestMapping("multipartUpload")
    public String multipartUpload(@RequestParam("file") CommonsMultipartFile file, HttpSession httpSession) throws Exception {
        System.out.println(file.getName());//ǰ��name�����е�����
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());

        String realPath = httpSession.getServletContext().getRealPath("/");
        File upload = new File(realPath);
        upload = new File(realPath + "upload/" + file.getOriginalFilename());

        if (!upload.exists()) {
            upload.mkdirs();
        }
        file.transferTo(upload);
        return "second.jsp";
    }

    //rest��񴫲����û��.+�ᵼ���ļ���Ϊ1������1.jpg
    @RequestMapping("download/{filename:.+}")
    public ResponseEntity<byte[]> download(@PathVariable String filename, HttpSession httpSession) throws Exception {
        //���������������
        //filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");

        //��ȡ�ļ�·��
        String realPath = httpSession.getServletContext().getRealPath("/");
        realPath = realPath + "/download/" + filename;

        //����ϵͳ
        FileInputStream fileInputStream = new FileInputStream(realPath);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);

        //��װ����ͷ
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpStatus ok = HttpStatus.OK;
        String encodeName = URLEncoder.encode(filename, "UTF-8");
        httpHeaders.add("Content-disposition", "attachment;filename=" + encodeName);
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, httpHeaders, ok);

        //�ر���Դ
        fileInputStream.close();
        return responseEntity;
    }


}
