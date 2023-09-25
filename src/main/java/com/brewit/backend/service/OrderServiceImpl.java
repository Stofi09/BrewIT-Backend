package com.brewit.backend.service;

import com.brewit.backend.model.Beer;
import com.brewit.backend.model.BeerOrder;
import com.brewit.backend.model.BrewITUser;
import com.brewit.backend.model.OrderItem;
import com.brewit.backend.model.dto.OrderDTO;
import com.brewit.backend.model.dto.OrderItemDTO;
import com.brewit.backend.repository.BeerOrderRepository;
import com.brewit.backend.repository.BeerRepository;
import com.brewit.backend.repository.BrewITUserRepository;
import com.brewit.backend.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService{

    private final BrewITUserRepository userRepository;
    private final BeerOrderRepository orderRepository;
    private final BeerRepository beerRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderServiceImpl(BrewITUserRepository userRepository,
                            BeerOrderRepository orderRepository,
                            BeerRepository beerRepository,
                            OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.beerRepository = beerRepository;
        this.orderItemRepository = orderItemRepository;
    }
    @Override
    public void processOrder(OrderDTO orderDTO) {
        BrewITUser user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid User ID"));

        BeerOrder order = new BeerOrder();
        order.setUser(user);

        for (OrderItemDTO itemDTO : orderDTO.getItems()) {
            Beer beer = beerRepository.findById(itemDTO.getBeerId())
                    .orElseGet(() -> {
                        Beer newBeer = new Beer();
                        newBeer.setId(itemDTO.getBeerId());
                        newBeer.setName(itemDTO.getBeerName());
                        beerRepository.save(newBeer);
                        return newBeer;
                    });

            OrderItem orderItem = new OrderItem();
            orderItem.setBeer(beer);
            orderItem.setQuantity(itemDTO.getCount());
            orderItem.setTotalPrice(itemDTO.getTotalPrice());
            order.addOrderItem(orderItem);
        }
        orderRepository.save(order);
    }

}
