package edu.wctc.wholesale.controller;


import edu.wctc.wholesale.dto.WholesaleDTO;
import edu.wctc.wholesale.entity.WholesaleOrder;
import edu.wctc.wholesale.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/orders/")
public class WholesaleRestController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ModelMapper modelMapper;

    private WholesaleDTO convertToDto(WholesaleOrder wholesaleOrder) {
        return modelMapper.map(wholesaleOrder, WholesaleDTO.class);
    }

    @GetMapping("/")
    public List<WholesaleDTO> getWholesaleOrders(){
        return orderService.getOrderList().stream()
                .map(this::convertToDto).collect(Collectors.toList());
    }

}
