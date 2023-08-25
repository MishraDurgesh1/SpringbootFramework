package com.practice.Api.Creation.service.impl;

import com.practice.Api.Creation.model.App;
import com.practice.Api.Creation.repository.AppRepository;
import com.practice.Api.Creation.service.AppService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class AppServiceImplTest {

    @Mock
    private AppRepository appRepository;
    private AppService appService;
    AutoCloseable autoCloseable;
    App app;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        appService = new AppServiceImpl(appRepository);
        app = new App("1", "Amazon",
                "USA", "xxxxx");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor() {
        mock(App.class);
        mock(AppRepository.class);

        when(appRepository.save(app)).thenReturn(app);
        assertThat(appService.createCloudVendor(app)).isEqualTo("Success");
    }

    @Test
    void testUpdateCloudVendor() {
        mock(App.class);
        mock(AppRepository.class);

        when(appRepository.save(app)).thenReturn(app);
        assertThat(appService.updateCloudVendor(app)).isEqualTo("Success");
    }

    @Test
    void testDeleteCloudVendor() {
        mock(App.class);
        mock(AppRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(appRepository)
                .deleteById(any());
        assertThat(appService.deleteCloudVendor("1")).isEqualTo("Success");
    }

    @Test
    void testGetCloudVendor() {
        mock(App.class);
        mock(AppRepository.class);

        when(appRepository.findById("1")).thenReturn(Optional.ofNullable(app));

        assertThat(appService.getCloudVendor("1").getVendorName())
                .isEqualTo(app.getVendorName());
    }

    @Test
    void testGetByVendorName() {
        mock(App.class);
        mock(AppRepository.class);

        when(appRepository.findByVendorName("Amazon")).
                thenReturn(new ArrayList<App>(Collections.singleton(app)));

//        assertThat(cloudVendorService.getByVendorName("Amazon").get(0).getVendorId()).
//                isEqualTo(cloudVendor.getVendorId());
    }

    @Test
    void testGetAllCloudVendor() {
        mock(App.class);
        mock(AppRepository.class);

        when(appRepository.findAll()).thenReturn(new ArrayList<App>(
                Collections.singleton(app)
        ));

        assertThat(appService.getAllCloudVendor().get(0).getVendorPhoneNumber()).
                isEqualTo(app.getVendorPhoneNumber());
    }
}