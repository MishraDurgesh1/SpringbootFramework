package com.practice.Api.Creation.controller;

import com.practice.Api.Creation.model.App;
import com.practice.Api.Creation.response.ResponseHandler;
import com.practice.Api.Creation.service.AppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudvendor")
public class AppController {
    AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    //read specific from DB
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getVendorDetails(@PathVariable("vendorId") String vendorId) {
        return ResponseHandler.responseBuilder("Requested Vendor details are given here", HttpStatus.OK, appService.getCloudVendor(vendorId));

    }

    //Read all cloud vendor details from DB
    @GetMapping()
    public ResponseEntity<Object> getAllVendorDetails() {
        return ResponseHandler.responseBuilder("Requested all vemdor details are given here",HttpStatus.OK, appService.getAllCloudVendor());
    }

    @PostMapping
    public String createCloudVendor(@RequestBody App app) {
        appService.createCloudVendor(app);
        return "Cloud vendor created successfully";
    }

    @PutMapping
    public String updateCloudVendor(@RequestBody App app) {
        appService.updateCloudVendor(app);
        return "Cloud vendor updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendor(@PathVariable("vendorId") String vendorId) {
        appService.deleteCloudVendor(vendorId);
        return "Cloud vendor deleted successfully";
    }
}
