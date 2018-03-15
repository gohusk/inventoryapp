package com.inventory.item;

import com.inventory.item.controller.InventoryController;
import com.inventory.item.model.InventoryType;
import com.inventory.item.repositories.InventoryRepository;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*Unit test coveraage for the get inventory type endpoint.
 Tests emptry response, filtered by active response, and get all response
 with mocked data.
 */
public class InventoryControllerTest {

    private List<InventoryType> mockReturn =  Arrays.asList(
            new InventoryType("test_1", true),
            new InventoryType("test_2", true),
            new InventoryType("test_3", false)
    );

    private List<InventoryType> mockEmptyReturn = new ArrayList<>();
    private InventoryController testController = new InventoryController();


    /**
     * Test that controller can return all inventory types
     */
    @Test
    public void testCanGetAllInventoryTypes() {
        InventoryRepository inventoryRepositoryMock = mock(InventoryRepository.class);
        when(inventoryRepositoryMock.findAll()).thenReturn(mockReturn);
        ReflectionTestUtils.setField(testController, "inventoryRepository", inventoryRepositoryMock);
        List<InventoryType> results = testController.getAll();
        assert (results.size() == 3);
    }

    /**
     * Test that controller can return all active inventory types
     */
    @Test
    public void testCanGetAllActiveInventoryTypes() {
        InventoryRepository inventoryRepositoryMock = mock(InventoryRepository.class);
        when(inventoryRepositoryMock.findAll()).thenReturn(mockReturn);
        ReflectionTestUtils.setField(testController, "inventoryRepository", inventoryRepositoryMock);
        List<InventoryType> results = testController.getAllActive();
        assert (results.size() == 2);
    }

    /**
     * Test that the controller will return an empty list if there are no active inventory types.
     */
    @Test
    public void testCanGetEmptyResponse() {
        InventoryRepository inventoryRepositoryMock = mock(InventoryRepository.class);
        when(inventoryRepositoryMock.findAll()).thenReturn(mockEmptyReturn);
        ReflectionTestUtils.setField(testController, "inventoryRepository", inventoryRepositoryMock);
        List<InventoryType> results = testController.getAllActive();
        assert (results.size() == 0);
    }
}
