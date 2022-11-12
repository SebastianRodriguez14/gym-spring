package com.tecfit.service;

import com.tecfit.model.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {


    File postFile(MultipartFile multipartFile) throws IOException;

    File updateFile(MultipartFile multipartFile, Integer idFile) throws IOException;

}
