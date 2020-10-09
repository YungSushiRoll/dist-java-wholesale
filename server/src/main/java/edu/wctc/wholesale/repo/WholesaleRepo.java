package edu.wctc.wholesale.repo;
import edu.wctc.wholesale.entity.WholesaleOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WholesaleRepo extends CrudRepository<WholesaleOrder, Integer> {
    List<WholesaleOrder> findAllByOrderById();
}
