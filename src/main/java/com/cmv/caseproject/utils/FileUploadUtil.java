package com.cmv.caseproject.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cmv.caseproject.exception.FilenameAlreadyInUseException;

@Service
public class FileUploadUtil {
    
    public static void saveFile(String uploadDir, String fileName,
            MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
         
        if (Files.exists(uploadPath)) {
            throw new FilenameAlreadyInUseException("Filename already in use.");
        }
        
        Files.createDirectories(uploadPath);
         
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + fileName, ioe);
        }      
    }
    
    public static void updateFile(String uploadDir, String fileName,
            MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
         
        try (InputStream inputStream = multipartFile.getInputStream()) {
        	File tempFile = new File(uploadPath.toString());
            FileUtils.cleanDirectory(tempFile);
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + fileName, ioe);
        }      
    }
    
    public static void deleteFile(String uploadDir) throws IOException {
        try {
        	Path uploadPath = Paths.get(uploadDir);
        	File tempFile = new File(uploadPath.toString());
			FileUtils.deleteDirectory(tempFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
