package repository;

import java.util.List;

public interface CrudRepository <T,ID> extends SuperDao{

    Boolean save(T entity);

    Boolean update(T entity);

    T search(ID id);

    Boolean delete(ID id);

    List<T> getAll();
}
