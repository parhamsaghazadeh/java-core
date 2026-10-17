public interface Repository<T> {

    void save(T object);

    T findById(long id);

    void delete(T object);
}
