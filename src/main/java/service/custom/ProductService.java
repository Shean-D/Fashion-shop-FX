package service.custom;

import model.dto.ProductDTO;
import service.SuperService;

import java.sql.SQLException;
import java.util.List;

public interface ProductService extends SuperService {

    List<ProductDTO> getAllProducts() throws SQLException;

    Boolean addProduct(ProductDTO product);

    Boolean updateProduct(ProductDTO product);

    Boolean deleteProduct(ProductDTO product);

    ProductDTO getProductById(int id) throws SQLException;

    List<String> getAllProductIDs() throws SQLException;
}
