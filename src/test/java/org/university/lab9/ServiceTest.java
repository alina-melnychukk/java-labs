package org.university.lab9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class ServiceTest {

    @Test
    void testFetchDataFromApi() {
        Service apiService = new Service();
        Map<String, Object> data = apiService.fetchDataFromApi();
        Assertions.assertNotNull(data);
    }

    @Test
    void testCreateExcelFile() {
        Service apiService = new Service();
        Map<String, Object> testData = Map.of("1", "Test Country 1", "2", "Test Country 2");
        apiService.createExcelFile(testData);
    }
}