package repository.custom.Impl;

import model.entity.OrderItemEntity;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class OrderDetailsRepositoryImpl {

    public Boolean addOrderDetails(Session session,List<OrderItemEntity> orderItemEntities) {
        for (OrderItemEntity item : orderItemEntities) {
            Boolean added = addOrderDetails(session,item);
            if (!added) {
                return false;
            }
        }
        return true;
    }

    public Boolean addOrderDetails(Session session,OrderItemEntity item) {

        item.setId(null);
        session.beginTransaction();
        session.save(item);


        return true;
    }
}
