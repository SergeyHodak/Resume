package resume.base_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
public class Controller1 {
    @GetMapping("/")
    public String getResumePage(Model model) {
        String filename = "images/Serge.jpg";
        String fileURL = "D:/JavaSerge/Resume/src/main/resources/static/" + filename;
        int requiredImageHeight = 400;
        int width = 0;
        BufferedImage img;
        try {
            img = ImageIO.read(new File(new URI(fileURL).getPath()));
            int height = img.getHeight();
            width = img.getWidth()/100*(requiredImageHeight/(height/100));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("filename", filename);
        model.addAttribute("height", requiredImageHeight);
        model.addAttribute("width", width != 0 ? width : "auto");
        return "resume";
    }
}
