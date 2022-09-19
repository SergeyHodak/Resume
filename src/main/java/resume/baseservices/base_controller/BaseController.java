package resume.baseservices.base_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@Controller
public class BaseController {
    @GetMapping("/")
    public String getResumePage(Model model) {
        File urlProjectClass = new File(Objects.requireNonNull(this.getClass().getResource("")).getPath());
        String urlProject = urlProjectClass.toString().replace("\\", "/");
        String[] folders = urlProject.split("/");
        StringBuilder resultURL = new StringBuilder();
        for (String folder : folders) {
            if (Objects.equals(folder, "Resume")) {
                resultURL.append(folder).append("/src/main/resources/static/");
                break;
            } else {
                resultURL.append(folder).append("/");
            }
        }
        String filename = "images/Serge.jpg";
        String fileURL = resultURL.append(filename).toString();
        int requiredImageHeight = 376;
        int width;
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
