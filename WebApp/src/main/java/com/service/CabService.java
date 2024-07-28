package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.viewmodel.CabPagedListRequestViewModel;
import com.viewmodel.CabPagedListResponseViewModel;
import com.viewmodel.CabViewModel;

@Service
public class CabService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${cab.service.url}")
    private String cabBaseUrl;

    public CabPagedListResponseViewModel SearchCab(CabPagedListRequestViewModel model) {
        try {
            String seviceUrl = cabBaseUrl + "/cab?" + GetQueryString(model);
            CabPagedListResponseViewModel response = restTemplate.getForObject(seviceUrl,
                    CabPagedListResponseViewModel.class);
            return response;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return new CabPagedListResponseViewModel(new ArrayList<CabViewModel>(), 0);
        }
    }

    public CabViewModel GetCab(int id) {
        try {
            String serviceUrl = cabBaseUrl + "/cab/" + id;
            CabViewModel response = restTemplate.getForObject(serviceUrl, CabViewModel.class);
            return response;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return new CabViewModel();
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
}
