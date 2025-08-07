package service.custom;

import model.dto.CatergoryDTO;
import service.SuperService;

import java.util.List;

public interface CategoryService extends SuperService {
    List<CatergoryDTO> getAllCategories();

    Boolean addCategory(CatergoryDTO category);

    Boolean updateCategory(CatergoryDTO category);

    Boolean deleteCategory(CatergoryDTO category);

    CatergoryDTO searchCategoryByID(Integer Id);
}
