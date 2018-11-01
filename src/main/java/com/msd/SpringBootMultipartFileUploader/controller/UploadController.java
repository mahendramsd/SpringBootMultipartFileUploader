package com.msd.SpringBootMultipartFileUploader.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
public class UploadController {

    @RequestMapping(value = "uploadCapFile", method = RequestMethod.POST)
    public ModelAndView singleFileUpload(@RequestParam("file") MultipartFile file,
                                         Model model) {

        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload");
            return new ModelAndView("uploadStatus");
        }
        try {
            model.addAttribute("message",
                    "You successfully uploaded : '" + file.getOriginalFilename() + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("uploadStatus");
    }
}
