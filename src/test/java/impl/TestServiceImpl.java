package impl;

import com.ecom.product.model.EcomProductModel;
import com.ecom.product.repository.EcomProductDao;
import com.ecom.product.service.EcomProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
//@SpringBootConfiguration
@ExtendWith(MockitoExtension.class)
class TestServiceImpl {


    @InjectMocks
    @Spy
    private EcomProductServiceImpl ecomProductService = new EcomProductServiceImpl();
    @Mock
    private EcomProductDao ecomProductDao;

        @Test
        void Test() {
            System.out.println("TEST");
            System.out.println(ecomProductDao.save(new EcomProductModel("samsung", "note 20", 15000D, 20)));
        }
    }
