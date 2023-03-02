package com.example.controller;

import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    ISongService songService;
    @GetMapping("/upload")
    public String showUploadForm (Model model) {
        model.addAttribute("song", new Song());
        model.addAttribute("categoryList", Arrays.asList("rap", "melody", "pop", "rock"));
        return "upload";
    }
     @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("songList", songService.listSong());
        return "list";
     }

     @PostMapping("")
    public String performUploadw(@ModelAttribute Song song, RedirectAttributes redirectAttributes) {
        songService.addSong(song);
        return "redirect:/song";
     }

}
