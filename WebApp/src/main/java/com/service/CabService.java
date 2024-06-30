package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.viewmodel.BookRequestViewModel;
import com.viewmodel.BookResponseViewModel;
import com.viewmodel.CabPagedListRequestViewModel;
import com.viewmodel.CabPagedListResponseViewModel;
import com.viewmodel.CabViewModel;

@Service
public class CabService {
    @Autowired
    RestTemplate restTemplate;

    public CabPagedListResponseViewModel SearchCab(CabPagedListRequestViewModel model) {
        try {
            String cabUrl = "http://localhost:8282/cab?" + GetQueryString(model);
            CabPagedListResponseViewModel response = restTemplate.getForObject(cabUrl,
                    CabPagedListResponseViewModel.class);
            return response;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return new CabPagedListResponseViewModel(new ArrayList<CabViewModel>(), 0);
        }
    }

    private String GetQueryString(Object model) {
        String queryString = "";
        try {
            java.lang.reflect.Field[] fields = model.getClass().getDeclaredFields();
            for (java.lang.reflect.Field field : fields) {
                field.setAccessible(true);
                if (field.get(model) != null) {
                    queryString += field.getName() + "=" + field.get(model) + "&";
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return queryString;
    }

    public CabViewModel GetCab(int id) {
        try {
            String cabUrl = "http://localhost:8282/cab/" + id;
            CabViewModel response = restTemplate.getForObject(cabUrl, CabViewModel.class);
            return response;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return new CabViewModel();
        }
    }

    public BookResponseViewModel Book(BookRequestViewModel model) {
        try {
            String cabUrl = "http://localhost:8181/book/";
            BookResponseViewModel response = restTemplate.postForObject(cabUrl, model, BookResponseViewModel.class);
            return response;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
