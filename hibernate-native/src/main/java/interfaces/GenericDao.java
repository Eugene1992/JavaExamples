package interfaces;

import java.io.Serializable;

public interface GenericDao<T, PK extends Serializable> {
    void create(T t);

    T read(PK id);

    void update(T t);

    void delete(T t);
}
