package com.scg.api.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/*
* 파일 업로드 할때 사용하는 것
 */

public class UploadFunction {
    private static final Logger logger = LoggerFactory.getLogger(UploadFunction.class);
    public void writeFile(MultipartFile file,String filename,HttpServletRequest request,String rootPath){

        try {

            byte[] bytes = file.getBytes();

            File dir = new File(rootPath);

            File serverFile = new File(dir+ File.separator + filename);

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

            stream.write(bytes);
            stream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void boardDeleteFile(HttpServletRequest request,String filename){

        String rootPath = request.getSession().getServletContext().getRealPath("/") + "/" + "resources/board/";
        File dir = new File(rootPath);
        File serverFile = new File(dir+ File.separator + filename);

        try{

            serverFile.delete();
            logger.info("파일을 정삭적으로 지웠습니다 " + serverFile.getPath());
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
