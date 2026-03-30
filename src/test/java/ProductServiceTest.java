import com.ecomerce.mock.ecommerce_api.dto.ProductDTO;
import com.ecomerce.mock.ecommerce_api.dto.ProductResponse;
import com.ecomerce.mock.ecommerce_api.dto.ProductResponseDTO;
import com.ecomerce.mock.ecommerce_api.integration.ProductClient;
import com.ecomerce.mock.ecommerce_api.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest  {

@Mock
    private ProductClient productClient;
@InjectMocks
    private ProductService productService;
@Test
void shouldReturnMappedProductListWhenClientReturnsProducts(){
    ProductDTO productDTO = new ProductDTO();
    productDTO.setId(500L);
    productDTO.setTitle("Iphone17");
    productDTO.setPrice(BigDecimal.valueOf(3590));

    ProductResponseDTO responseDTO = new ProductResponseDTO();
    responseDTO.setProducts(List.of(productDTO));
    when(productClient.getProducts()).thenReturn(responseDTO);

    List<ProductResponse> result = productService.listProducts();

    assertEquals(1, result.size());
    assertEquals(500L, result.get(0).getId());
    assertEquals("Iphone17", result.get(0).getName());
    assertEquals(BigDecimal.valueOf(3590), result.get(0).getPrice());

}

    @Test
    void shouldReturnEmptyListWhenClientReturnsNullResponse() {
        when(productClient.getProducts()).thenReturn(null);

        List<ProductResponse> result = productService.listProducts();

        assertEquals(0, result.size());
    }
    @Test
    void shouldReturnEmptyListWhenResponseProductsIsNull() {
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setProducts(null);

        when(productClient.getProducts()).thenReturn(responseDTO);

        List<ProductResponse> result = productService.listProducts();

        assertEquals(0, result.size());
    }
}
