package service.custom.impl;

import model.dto.SupplierDTO;
import service.custom.SupplierService;

import java.util.List;

public class SupplierServiceImpl implements SupplierService {
    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return List.of();
    }

    @Override
    public Boolean addSupplier(SupplierDTO supplier) {
        return null;
    }

    @Override
    public Boolean updateSupplier(SupplierDTO supplier) {
        return null;
    }

    @Override
    public Boolean deleteSupplier(SupplierDTO supplier) {
        return null;
    }

    @Override
    public SupplierDTO searchSupplierById(Integer supplierId) {
        return null;
    }
}
