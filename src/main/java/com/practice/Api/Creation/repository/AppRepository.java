package com.practice.Api.Creation.repository;

import com.practice.Api.Creation.model.App;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppRepository extends JpaRepository <App,String>{
    List<App> findByVendorName(String vendorName);
}
