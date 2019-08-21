package com.alexbergman.auction.repository;

import com.alexbergman.auction.entity.AuctionItem;
import com.alexbergman.auction.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

}
