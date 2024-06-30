package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import com.service.CabService;
import com.viewmodel.CabPagedListRequestViewModel;
import com.viewmodel.CabPagedListResponseViewModel;
import com.viewmodel.CabViewModel;

@Controller
public class CabController {
    @Autowired
    CabService cabService;

    @RequestMapping(value = "/cab", method = RequestMethod.GET)
    public String Index() {
        return "cab/index"; // view resolver responsible to check the page inside folder.
    }

    @RequestMapping(value = "/cab/search", method = RequestMethod.GET)
    public String Search(@ModelAttribute CabPagedListRequestViewModel search, Model model) {
        search.setIsAvailable(true);
        search.setOrderBy("amount");
        search.setOrder("asc");
        model.addAttribute("search", search);
        CabPagedListResponseViewModel cabs = cabService.SearchCab(search);
        model.addAttribute("cabs", cabs);
        return "cab/search";
    }

    @RequestMapping(value = "/cab/{id}", method = RequestMethod.GET)
    public String Index(@PathVariable("id") int id, Model model) {
        CabViewModel cab = cabService.GetCab(id);
        if (!cab.isIsAvailable()) {
            model.addAttribute("message", "Cab is not available");
            return "book/book";
        }
        model.addAttribute("cab", cab);
        return "book/book"; // view resolver responsible to check the page inside folder.
    }
}
