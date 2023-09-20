package com.pos.pointOfSale.repository;

import com.pos.pointOfSale.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {
    List<Item> findByActiveStateEquals(boolean status);
}
