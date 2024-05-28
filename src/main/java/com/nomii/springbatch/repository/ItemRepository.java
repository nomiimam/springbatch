package com.nomii.springbatch.repository;

import com.nomii.springbatch.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
