package repository;

import com.practice.Api.Creation.ApiCreationApplication;
import com.practice.Api.Creation.model.App;
import com.practice.Api.Creation.repository.AppRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ContextConfiguration(classes = ApiCreationApplication.class)
public class AppRepositoryTest {
    @Autowired
    AppRepository appRepository;
    App app;

    @BeforeEach
    void setUp() {
        app = new App("1", "Amazon", "India", "xxxxx");
        appRepository.save(app);
    }

    @AfterEach
    void tearDown() {
        app = null;
        appRepository.deleteAll();
    }

    @Test
    void testFindByVendorName_Found() {
        List<App> appList = appRepository.findByVendorName("Amazon");
        assertThat(appList.get(0).getVendorId()).isEqualTo(app.getVendorId());
        assertThat(appList.get(0).getVendorAddress()).isEqualTo(app.getVendorAddress());
        assertThat(appList.get(0).getVendorPhoneNumber()).isEqualTo(app.getVendorPhoneNumber());
    }

    @Test
    void testFindByVendorName_NotFound() {
        List<App> appList2 = appRepository.findByVendorName("Flipkart");
        assertThat(appList2.isEmpty()).isTrue();
    }
}
