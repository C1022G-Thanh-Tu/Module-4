package com.example.login.controller;

import com.example.login.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
@SessionAttributes("userDTO")
public class UserController {

    @ModelAttribute("userDTO")
    public UserDTO setUpUserForm() {
        return new UserDTO();
    }

    @GetMapping("")
    public String Index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "/login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute("userDTO") UserDTO userDTO, Model model,
                          @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse httpServletResponse,
                          HttpServletRequest httpServletRequest) {
        if (userDTO.getEmail().equals("admin@gmail.com") && userDTO.getPassword().equals("12345")) {
            if (userDTO.getEmail() != null) {
                setUser = userDTO.getEmail();
            }
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(60 * 60 * 24);
            httpServletResponse.addCookie(cookie);

            Cookie[] cookies = httpServletRequest.getCookies();
            for (Cookie ck : cookies) {
                if (ck.getName().equals("setUser")) {
                    model.addAttribute("cookieValue", ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue", ck);
                    break;
                }
            }
            model.addAttribute("message", "Login success. Welcome ");
        } else {
            userDTO.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "/login";
    }
}
