import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ItemsListComponent } from './items-list/items-list.component';
import { AuctionServiceService } from './auction-service.service'

@NgModule({
  declarations: [
    AppComponent,
    ItemsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [AuctionServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
