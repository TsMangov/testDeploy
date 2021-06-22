package bigproject.demo.service;

import bigproject.demo.model.entities.ProductEntity;
import bigproject.demo.model.service.ProductServiceModel;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    void initProducts();
    List<ProductEntity> getAllProducts();

    void deleteById(Long id);

    void addNewProduct(ProductServiceModel model) throws IOException;

}
