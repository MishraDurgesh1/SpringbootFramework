package com.practice.Api.Creation.service.impl;

import com.practice.Api.Creation.exception.ApplicationNotFoundException;
import com.practice.Api.Creation.model.App;
import com.practice.Api.Creation.repository.AppRepository;
import com.practice.Api.Creation.service.AppService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppServiceImpl implements AppService {
    AppRepository appRepository;

    public AppServiceImpl(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    @Override
    public String createCloudVendor(App app) {
        appRepository.save(app);
        return "Success";
    }

    @Override
    public String updateCloudVendor(App app) {
        appRepository.save(app);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        appRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public App getCloudVendor(String cloudVendorId) {
        if(appRepository.findById(cloudVendorId).isEmpty())
            throw new ApplicationNotFoundException("Requested Cloud Vendor does not exist");
        return appRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<App> getAllCloudVendor() {
        return appRepository.findAll();
    }
}
