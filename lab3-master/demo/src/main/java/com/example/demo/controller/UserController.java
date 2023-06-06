    package com.example.demo.controller;
    import java.util.List;
    import com.example.demo.services.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;
    import com.example.demo.entity.User;
    import jakarta.validation.Valid;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.ui.Model;
    import org.springframework.validation.BindingResult;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.validation.FieldError;
    @Controller
    public class UserController {
        @Autowired
        private UserService userService;

        @GetMapping("/login")
        public String login() {
            return "user/login";
        }

        @GetMapping("/register")
        public String showRegistrationForm(Model model) {
            model.addAttribute("user", new User());
            return "user/register";
        }

        @PostMapping("/register")
        public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
            if (bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors) {
                    model.addAttribute(error.getField() + "_error",
                            error.getDefaultMessage());
                }
                return "user/register";
            }
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userService.save(user);
            return "redirect:/login";
        }
    }
