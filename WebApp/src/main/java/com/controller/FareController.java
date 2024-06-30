package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.FareService;
import com.viewmodel.FareViewModel;

@Controller
public class FareController {
    @Autowired
    FareService fareService;

    @RequestMapping(value = "/fare/{id}", method = RequestMethod.GET)
    public String Fair(@PathVariable("id") int id, Model model) {
        if (id <= 0)
            return "notfound";

        FareViewModel fare = fareService.GetByCabId(id);
        model.addAttribute("fare", fare);
        return "fair/_modal :: modal";
    }
}
