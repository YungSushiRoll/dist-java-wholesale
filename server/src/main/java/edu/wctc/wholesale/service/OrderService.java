package edu.wctc.wholesale.service;

import edu.wctc.wholesale.entity.WholesaleOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    List<WholesaleOrder> getOrderList();
}
