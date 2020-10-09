package edu.wctc.wholesale.service;

import edu.wctc.wholesale.entity.WholesaleOrder;
import edu.wctc.wholesale.repo.WholesaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasicOrderService implements OrderService {

    @Autowired
    private WholesaleRepo wholesaleRepo;

    @Override
    public List<WholesaleOrder> getOrderList() {
        List<WholesaleOrder> orderList = new ArrayList<>();
        wholesaleRepo.findAllByOrderById().forEach(orderList::add);
        return orderList;
    }
}
