package uz.qbg.apptelegramBot.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/attachment")
public class AttachmentController {
    String uploadDir = "yuklanganlar";

     @GetMapping
    public void getfileByName (@RequestParam String name, HttpServletResponse respons) throws IOException {
         File file =new File(uploadDir+"/"+name);
         respons.setContentType("image/jpeg");
         respons.setHeader("Cache_Control","max-age=8640000");
         respons.setHeader("Content-disposition", "attachment; filename=\""+file.getName()+"\"");
         InputStream inputStream =new FileInputStream(file);
         FileCopyUtils.copy(inputStream,respons.getOutputStream());
    }
}
