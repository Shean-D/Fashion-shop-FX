package repository.custom.Impl;

import model.entity.OrderItemEntity;
import model.entity.ProductEntity;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;


public class ProductRepositoryImpl {

    public boolean updateStock(Session session, List<OrderItemEntity> items) {
        for (OrderItemEntity item : items) {
            // Validate the item has required data
            if (item == null) {
                throw new IllegalArgumentException("OrderItemEntity is null");
            }

            if (item.getQuantity() == null || item.getQuantity() <= 0) {
                throw new IllegalArgumentException("Invalid quantity for item: " + item.getQuantity());
            }

            if (item.getProduct() == null) {
                throw new IllegalArgumentException("Product is null for item: " + item);
            }

            // Get product ID - check multiple possible sources
            Integer productId = null;

            // First try to get from the product entity
            if (item.getProduct().getProductsId() != null) {
                productId = item.getProduct().getProductsId();
            }
            // If product ID is null, try to find by product name (if you have a unique constraint)
            else if (item.getProduct().getProductName() != null) {
                ProductEntity existingProduct = (ProductEntity) session.createQuery(
                                "FROM ProductEntity WHERE productName = :name")
                        .setParameter("name", item.getProduct().getProductName())
                        .uniqueResult();

                if (existingProduct != null) {
                    productId = existingProduct.getProductsId();
                    item.setProduct(existingProduct); // Update the item with the complete product
                }
            }

            if (productId == null) {
                throw new IllegalArgumentException("Cannot determine product ID for item with product: " +
                        item.getProduct().getProductName());
            }

            // Get the managed product entity
            ProductEntity managedProduct = session.get(ProductEntity.class, productId);
            if (managedProduct == null) {
                throw new RuntimeException("Product not found in DB with ID: " + productId);
            }

            // Check if we have enough stock
            if (managedProduct.getQtyOnHand() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product " + managedProduct.getProductName() +
                        ". Available: " + managedProduct.getQtyOnHand() + ", Required: " + item.getQuantity());
            }

            for (OrderItemEntity item1 : items) {
                System.out.println("Item: " + item1);
                System.out.println("Quantity: " + item1.getQuantity());
                System.out.println("Product: " + item1.getProduct());
            }

            // Update stock
            session.createQuery("UPDATE ProductEntity p " +
                            "SET p.qtyOnHand = p.qtyOnHand - :qty " +
                            "WHERE p.productsId = :id")
                    .setParameter("qty", item.getQuantity())
                    .setParameter("id", productId)
                    .executeUpdate();

            // Set the complete managed product on the item
            item.setProduct(managedProduct);
        }

        // Save all items
        for (OrderItemEntity item : items) {
            session.saveOrUpdate(item);
        }

        return true;
    }
}





//    public Boolean updateStock(OrderItemEntity item){
//
//        Session session = HibernateUtil.getSession();
//
//        session.beginTransaction();
//        ProductEntity product = session.get(ProductEntity.class, item.getId());
//        product.setQtyOnHand(product.getQtyOnHand() - item.getQuantity());
//        session.update(product);
//        session.getTransaction().commit();
//        session.close();
//        return true;
//    }

