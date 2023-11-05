package com.binarfud.challenge6.Service;

import com.binarfud.challenge6.Model.OrdersDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {

    List<OrdersDetail> getAllOrderDetail();

    Boolean addNewOrderDetail(OrdersDetail orderDetail);
}
