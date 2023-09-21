package com.pos.pointOfSale.repository;

import com.pos.pointOfSale.entity.Item;
import com.pos.pointOfSale.entity.enums.MeasuringUnits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@EnableJpaRepositories
@Repository
@Transactional
public interface ItemRepo extends JpaRepository<Item,Integer> {
    List<Item> findByActiveStateEquals(boolean status);

    @Modifying
    @Query(value = "update item set item_name=?1, measuring_unit=?2, balance_qty=?3, supplier_price=?4, selling_price=?5 where item_id=?6",nativeQuery = true)
    void updateItemByQuery(String itemName, String measuringUnit, double balanceQty, double supplierPrice, double sellingPrice, int id);

    //void updateItemByQuerys(String itemName, String measuringUnit, double balanceQty, double supplierPrice, double sellingPrice, int id);
}
