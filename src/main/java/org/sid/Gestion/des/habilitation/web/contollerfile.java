package org.sid.Gestion.des.habilitation.web;


import org.sid.Gestion.des.habilitation.entites.Application;
import org.sid.Gestion.des.habilitation.entites.Habilitation;
import org.sid.Gestion.des.habilitation.repositories.HabilitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@RestController


public class contollerfile {
    @Autowired
    HabilitationRepository repo;

    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/images";
    @PostMapping( "/addHablitation")

    public String saveHabilitation(Habilitation habilitation, @RequestParam("file") MultipartFile file
                                ) {


        StringBuilder fileNames = new StringBuilder();
        String filename=file.getOriginalFilename();
        Path fileNameAndPath = Paths.get(uploadDirectory,filename);
        try {

            Files.write(fileNameAndPath, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        habilitation.setAttachementFichier(filename);
        repo.save(habilitation);

        return "Save Data Successfully ! ";
    }





}
