package com.tecfit.rest;

import com.tecfit.model.File;
import com.tecfit.service.CloudinaryService;
import com.tecfit.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping("/post")
    public File postFile(@RequestParam MultipartFile multipartFile) throws IOException {
        return fileService.postFile(multipartFile);
    }

    @PutMapping("/put")
    public File putFile(@RequestParam MultipartFile multipartFile, @RequestParam Integer idFile) throws IOException{
        return fileService.updateFile(multipartFile, idFile);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Map> deleteFile(@PathVariable String id) throws IOException {
//        Map result = cloudinaryService.delete(id);
//        return new ResponseEntity(result, HttpStatus.OK);
//    }
}
