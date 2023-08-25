package com.practice.Api.Creation.service;

import com.practice.Api.Creation.model.App;

import java.util.List;

public interface AppService {
    public String createCloudVendor(App app);
    public String updateCloudVendor(App app);
    public String deleteCloudVendor(String cloudVendorId);
    public App getCloudVendor(String cloudVendorId);
    public List<App> getAllCloudVendor();

}
