package service.custom;

import model.dto.SupplierDTO;
import service.SuperService;

import java.util.List;

public interface SupplierService extends SuperService {

    List<SupplierDTO> getAllSuppliers();

    Boolean addSupplier(SupplierDTO supplier);

    Boolean updateSupplier(SupplierDTO supplier);

    Boolean deleteSupplier(SupplierDTO supplier);

    SupplierDTO searchSupplierById(Integer supplierId);
}
