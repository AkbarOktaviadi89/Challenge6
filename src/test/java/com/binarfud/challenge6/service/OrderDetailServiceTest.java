package com.binarfud.challenge6.service;

import com.binarfud.challenge6.Model.OrdersDetail;
import com.binarfud.challenge6.Repository.OrderDetailRepository;

import com.binarfud.challenge6.Service.Impl.OrderDetailServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderDetailServiceTest {

    @InjectMocks
    private OrderDetailServiceImpl orderDetailService;

    @Mock
    private OrderDetailRepository orderDetailRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllOrderDetail() {
        List<OrdersDetail> orderDetails = new ArrayList<>();
        when(orderDetailRepository.findAll()).thenReturn(orderDetails);

        List<OrdersDetail> result = orderDetailService.getAllOrderDetail();

        assertEquals(orderDetails, result);
        verify(orderDetailRepository).findAll();
    }

    @Test
    public void testAddNewOrderDetail() {
        OrdersDetail orderDetail = new OrdersDetail();
        when(orderDetailRepository.save(orderDetail)).thenReturn(orderDetail);

        boolean result = orderDetailService.addNewOrderDetail(orderDetail);

        assertTrue(result);
        verify(orderDetailRepository).save(orderDetail);
    }

    @Test
    public void testAddNewOrderDetailFail() {
        OrdersDetail orderDetail = new OrdersDetail();
        when(orderDetailRepository.save(orderDetail)).thenReturn(null);

        boolean result = orderDetailService.addNewOrderDetail(orderDetail);

        assertFalse(result);
        verify(orderDetailRepository).save(orderDetail);
    }
}
