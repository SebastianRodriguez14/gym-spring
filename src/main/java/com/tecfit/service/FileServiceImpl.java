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

        File file = new File(0, result.get("secure_url").toString());

        return fileRepository.save(file);
    }

    @Override
    public File updateFile(MultipartFile multipartFile, Integer idFile) throws IOException {

        File fileFind = fileRepository.findById(idFile).get();

        String[] parts_url = fileFind.getUrl().split("/");
        String[] parts_id_img = parts_url[parts_url.length-1].split("\\.");
        String id_image = parts_id_img[0];

        System.out.println(id_image);

        cloudinaryService.delete(id_image);

        Map result = cloudinaryService.upload(multipartFile);

        File file = new File(idFile, result.get("secure_url").toString());

        return fileRepository.save(file);
    }

    @Override
    public void deleteFile(Integer idFile) throws IOException {
        File fileFind = fileRepository.findById(idFile).get();
        String[] parts_url = fileFind.getUrl().split("/");
        String[] parts_id_img = parts_url[parts_url.length-1].split("\\.");
        String id_image = parts_id_img[0];
        cloudinaryService.delete(id_image);
        fileRepository.deleteById(idFile);
    }
}
