package com.javarush.cryptoanalyzer.polyakova.services;

import java.nio.file.Files;
import java.nio.file.Path;

public class PathValidator {
     public boolean pathValidator(String track){
          boolean txtFile = track.endsWith(".txt");
          Path path=Path.of(track);
          boolean isFile = Files.isRegularFile(path);
          boolean isExists = Files.exists(path);
          if (txtFile&&isFile&&isExists)
               return true;
          else return false;
     }



}
