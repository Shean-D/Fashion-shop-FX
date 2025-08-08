package util;

import model.dto.OrderItemDTO;
import model.entity.OrderItemEntity;
import org.modelmapper.ModelMapper;

public class ModelMapperUtil {
    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        // Custom mapping for OrderItemDTO -> OrderItemEntity
        modelMapper.typeMap(OrderItemDTO.class, OrderItemEntity.class)
                .addMappings(mapper -> mapper.map(OrderItemDTO::getOrderId, OrderItemEntity::setOrderId))
                .addMappings(mapper -> mapper.map(OrderItemDTO::getProductId, OrderItemEntity::setProductId));



        public static ModelMapper getModelMapper() {
        return modelMapper;
    }
}
