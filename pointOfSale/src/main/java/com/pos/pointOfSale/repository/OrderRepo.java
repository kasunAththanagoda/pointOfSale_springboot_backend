package com.pos.pointOfSale.repository;

import com.pos.pointOfSale.dto.QueryInterfaces.OrderDetailInterface;
import com.pos.pointOfSale.entity.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {




    @Query(value = "select c.customer_name as customerName, c.cutomer_address as customerAddress, c.contact_number as contactNumber, o.order_date as date, o.total as total from customer c, orders o where c.customer_id=o.customer_id and c.active_status=?1",nativeQuery = true)
    List<OrderDetailInterface> getAllOrderDetails(boolean state, Pageable of);

    @Query(value = "select count(*) from customer c, orders o where c.customer_id=o.customer_id and c.active_status=?1",nativeQuery = true)
    long countOrderDetails(boolean state);

    @Query(value = "select c.customer_name as customerName, c.cutomer_address as customerAddress, c.contact_number as contactNumber, o.order_date as date, o.total as total from customer c, orders o where c.customer_id=o.customer_id",nativeQuery = true)
    List<OrderDetailInterface> getAllWithhoutState(Pageable of);

    @Query(value = "select count(*) from customer c, orders o where c.customer_id=o.customer_id",nativeQuery = true)
    long countOrderDetailsWithoutState();
}
