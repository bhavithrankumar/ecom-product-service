package impl;

import com.ecom.product.controller.EcomProductController;
import com.ecom.product.dto.InsertRequestDto;
import com.ecom.product.service.EcomProductService;
import com.ecom.product.service.EcomProductServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class TestServiceImpl {
    private MockMvc mockMvc;
    @InjectMocks
    private EcomProductController ecomProductController;
    @Mock
    private EcomProductService ecomProductService;
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(ecomProductController).build();
    }

    @Test
    void Test() throws Exception{
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ecomProductController).build();
        InsertRequestDto request = new InsertRequestDto();
        request.setName("samsung");
        request.setDescription("Note 20");
        request.setPrice(75000D);
        request.setQuantityAvailable(20);
        when(ecomProductService.insertProduct(request)).thenReturn(true);
        MvcResult mvcResult =  mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8890/ecom/product/insert")
                        .content(new ObjectMapper().writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        verify(ecomProductService, times(1)).insertProduct(request);
        String responseContent = mvcResult.getResponse().getContentAsString();
        JsonNode responseJson = new ObjectMapper().readTree(responseContent);
        System.out.println("responseJson: {}"+responseJson);
        assertEquals("00", responseJson.path("respcode").asText());
        assertTrue(responseJson.path("responseMap").path("response").asBoolean());
    }
}
