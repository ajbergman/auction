package com.alexbergman.auction.controller;

import com.alexbergman.auction.entity.AuctionBid;
import com.alexbergman.auction.entity.AuctionItem;
import com.alexbergman.auction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @GetMapping(value = "/auctionItems")
    public List<AuctionItem> getAuctionItems() {
        return auctionService.getAuctionItems();
    }

    @GetMapping(value = "/auctionItems/{auctionItemId}")
    public AuctionItem getAuctionItem(@PathVariable Long auctionItemId) {
        return auctionService.getAuctionItem(auctionItemId);
    }

    @PostMapping(value = "/auctionItems")
    public AuctionItem putAuctionItem(@RequestBody AuctionItem auctionItem) {

        return auctionService.saveAuctionItem(auctionItem);
    }

    @PostMapping(value = "/bids")
    public void postBid(@RequestBody AuctionBid auctionBid) {

        auctionService.saveAuctionBid(auctionBid);

    }

}
