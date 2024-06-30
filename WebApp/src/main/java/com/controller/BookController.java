package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import com.service.CabService;
import com.viewmodel.BookRequestViewModel;
import com.viewmodel.BookResponseViewModel;
import com.viewmodel.CabViewModel;

@Controller
public class BookController {
    @Autowired
    CabService cabService;

    @RequestMapping(value = "/cab/book/{id}", method = RequestMethod.GET)
    public String Index(@PathVariable("id") int id, Model model) {
        CabViewModel cab = cabService.GetCab(id);
        if (!cab.isIsAvailable()) {
            model.addAttribute("message", "Cab is not available");
            return "cab/book";
        }
        model.addAttribute("cab", cab);
        return "cab/book"; // view resolver responsible to check the page inside folder.
    }

    @RequestMapping(value = "/cab/book", method = RequestMethod.POST)
    public String Book(@ModelAttribute BookRequestViewModel model) {
        BookResponseViewModel book = cabService.Book(model);
        if (book == null)
            return "redirect:/cab/book/0";
        return "redirect:/cab/booked/" + book.getBookId();
    }
}
