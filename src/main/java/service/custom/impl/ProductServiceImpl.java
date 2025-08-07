package service.custom.impl;

import db.DBConnection;
import model.dto.ProductDTO;
import service.custom.ProductService;
import util.Crudutil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<ProductDTO> getAllProducts() throws SQLException {
        ResultSet resultSet = Crudutil.execute("select * from product");
        List<ProductDTO> products = new ArrayList<>();
        while (resultSet.next()){
            products.add(new ProductDTO(
                    resultSet.getInt("products_id"),
                    resultSet.getString("product_name"),
                    resultSet.getString("size"),
                    resultSet.getDouble("price"),
                    resultSet.getInt("qty_on_hand"),
                    resultSet.getString("category"),
                    resultSet.getString("supplier")
            ));
        }
        return products;
    }

    @Override
    public Boolean addProduct(ProductDTO product) {
        return null;
    }

    @Override
    public Boolean updateProduct(ProductDTO product) {
        return null;
    }

    @Override
    public Boolean deleteProduct(ProductDTO product) {
        return null;
    }

    @Override
    public ProductDTO getProductById(int id) throws SQLException {

        ResultSet resultSet = Crudutil.execute("select * from product where products_id=?",id);
        if (resultSet.next()){
            return new ProductDTO(
                resultSet.getInt("products_id"),
                resultSet.getString("product_name"),
                resultSet.getString("size"),
                resultSet.getDouble("price"),
                resultSet.getInt("qty_on_hand"),
                resultSet.getString("category"),
                resultSet.getString("supplier")
            );
        }
        return null;
    }

    @Override
    public List<String> getAllProductIDs() throws SQLException {
        List<ProductDTO> all = getAllProducts();
        ArrayList<String> productIDs = new ArrayList<>();

        all.forEach(product -> {
            productIDs.add(String.valueOf(product.getProductsId()));
        });

        return productIDs;
    }
}
