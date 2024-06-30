package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.BookService;
import com.viewmodel.BookRequestViewModel;
import com.viewmodel.BookResponseViewModel;
import com.viewmodel.BookViewModel;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String Book(@ModelAttribute BookRequestViewModel model) {
        if (model.getEmail() == null || model.getEmail().isEmpty())
            return "redirect:/cab/0";
        if (model.getCabId() == null)
            return "redirect:/cab/0";
        BookResponseViewModel book = bookService.Book(model);
        if (book == null)
            return "redirect:/cab/0";
        return "redirect:/booked/" + book.getBookId();
    }

    @RequestMapping(value = "/booked/{id}", method = RequestMethod.GET)
    public String Booked(@PathVariable("id") int id, Model model) {
        if (id <= 0)
            return "redirect:/cab";

        BookViewModel book = bookService.Get(id);
        model.addAttribute("book", book);
        return "book/booked";
    }

    @RequestMapping(value = "/book/endtrip", method = RequestMethod.POST)
    public String EndTrip(@RequestParam("id") int id) {
        if (id <= 0)
            return "redirect:/cab";
        bookService.EndTrip(id);
        return "redirect:/cab";
    }
}
