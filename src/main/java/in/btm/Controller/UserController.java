package in.btm.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import in.btm.Entity.User;
import in.btm.Service.UserService;
import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/save")
    public String submitForm(@Valid @ModelAttribute("user") User user,
                             @RequestParam("resume") MultipartFile resume,
                             BindingResult result,
                             Model model) throws IOException {
        if (result.hasErrors()) {
            return "signup";
        }

        // Convert MultipartFile to byte[]
        if (resume != null && !resume.isEmpty()) {
            user.setResume(resume.getBytes());
        }

        userService.saveUser(user);
        return "success";
    }
}
