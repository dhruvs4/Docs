package assignment1.question3;

import java.util.List;
import java.util.Map;

public interface DataService<E , I> {

    E findById(I id);
    int getCount();
    List<E> findAll(Map<I,E> m) ;
    void deleteAll();
    boolean removeById(I id);
}
