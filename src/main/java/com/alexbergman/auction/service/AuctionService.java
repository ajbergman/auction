package com.alexbergman.auction.service;


import com.alexbergman.auction.entity.AuctionItem;
import com.alexbergman.auction.repository.AuctionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuctionService {

    @Autowired
    AuctionItemRepository auctionItemRepository;



    public List<AuctionItem> getAuctionItems() {
        return auctionItemRepository.findAll();
    }

    public AuctionItem saveAuctionItem(AuctionItem auctionItem) {
        if(auctionItem.getCurrentBid() == null)
            auctionItem.setCurrentBid(0.0);
        auctionItemRepository.save(auctionItem);
        return auctionItem;
    }
}
