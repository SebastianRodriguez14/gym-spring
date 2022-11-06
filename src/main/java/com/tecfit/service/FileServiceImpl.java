package com.tecfit.service;

import com.tecfit.model.File;
import com.tecfit.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    private FileRepository fileRepository;

    private CloudinaryService cloudinaryService = new CloudinaryService();

    @Override
    public File postFile(MultipartFile multipartFile) throws IOException {
        Map result = cloudinaryService.upload(multipartFile);

        File file = new File(result.get("public_id").toString(), result.get("secure_url").toString());

        return fileRepository.save(file);
    }

    @Override
    public File updateFile(MultipartFile multipartFile, String idFile) throws IOException {
        cloudinaryService.delete(idFile);
        fileRepository.deleteById(idFile);
        return postFile(multipartFile);
    }
}
