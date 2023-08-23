package com.practice.Api.Creation.controller;


import com.practice.Api.Creation.model.CloudVendor;
import com.practice.Api.Creation.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }
//read specific from DB
    @GetMapping("{vendorId}")
    public CloudVendor getVendorDetails(@PathVariable("vendorId") String vendorId) {
        return cloudVendorService.getCloudVendor(vendorId);
    }

    //Read all cloud vendor details from DB
    @GetMapping()
    public List<CloudVendor> getAllVendorDetails() {
        return cloudVendorService.getAllCloudVendor();
    }

    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud vendor created successfully";
    }

    @PutMapping
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud vendor updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendor(@PathVariable("vendorId") String vendorId){
      cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud vendor deleted successfully";
    }
}
