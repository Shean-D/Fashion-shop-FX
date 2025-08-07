package service.custom.impl;

import model.dto.CatergoryDTO;
import service.custom.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<CatergoryDTO> getAllCategories() {
        return List.of();
    }

    @Override
    public Boolean addCategory(CatergoryDTO category) {
        return null;
    }

    @Override
    public Boolean updateCategory(CatergoryDTO category) {
        return null;
    }

    @Override
    public Boolean deleteCategory(CatergoryDTO category) {
        return null;
    }

    @Override
    public CatergoryDTO searchCategoryByID(Integer Id) {
        return null;
    }
}
