package com.batch.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class adi extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Directory where the uploaded file will be saved
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Get the file part from the request
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();

        // Save the file to the server
        OutputStream out = new FileOutputStream(new File(uploadPath + File.separator + fileName));
        InputStream fileContent = filePart.getInputStream();
        int read = 0;
        final byte[] bytes = new byte[1024];
        while ((read = fileContent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        out.close();
        fileContent.close();

        // Process the uploaded file (separate background music and voice)
        // Add your processing logic here
        
        // Send response back to client
        response.getWriter().write("File " + fileName + " has been uploaded successfully!");
    }
}
