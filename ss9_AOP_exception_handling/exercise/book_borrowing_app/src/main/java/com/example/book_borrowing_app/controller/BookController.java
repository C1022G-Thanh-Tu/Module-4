package com.example.book_borrowing_app.controller;

import com.example.book_borrowing_app.model.Book;
import com.example.book_borrowing_app.model_dto.BookDTO;
import com.example.book_borrowing_app.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    public IBookService bookService;

    @GetMapping("")
    public String showAllList(Model model) {
        model.addAttribute("bookDTOList", bookService.findAllBook());
        return "/list";
    }

    @GetMapping("/borrow")
    public String performBorrow (@RequestParam Integer id) {
        BookDTO bookDTO = bookService.findById(id);
        bookDTO.borrow();
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        bookService.updateBook(book);
        return "redirect:/book";
    }

    @GetMapping("/giveBack")
    public String performGiveBack (@RequestParam String borrowCode, int id,
                                   RedirectAttributes redirectAttributes)  {
        BookDTO bookDTO = bookService.findById(id);
//        String msg = "";
//        try {
//            bookDTO.giveBack(borrowCode);
//        } catch (Exception e) {
//            msg = "Nhap sai code";
//        }
        bookDTO.giveBack(borrowCode);
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        bookService.updateBook(book);
//        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/book";
    }
}
