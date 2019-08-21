package com.alexbergman.auction.repository;

import com.alexbergman.auction.entity.AuctionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {

    public List<AuctionItem> findAll();


}
