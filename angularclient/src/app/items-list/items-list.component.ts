import { Component, OnInit } from '@angular/core';
import { AuctionItem } from '../auction-item';
import { AuctionServiceService } from '../auction-service.service';

@Component({
  selector: 'app-items-list',
  templateUrl: './items-list.component.html',
  styleUrls: ['./items-list.component.css']
})
export class ItemsListComponent implements OnInit {

  items: AuctionItem[];

  constructor(private auctionService: AuctionServiceService) { }

  ngOnInit() {
    this.auctionService.findAll().subscribe(data => {
          this.items = data;
        });
  }

}
