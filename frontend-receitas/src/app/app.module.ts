import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { NavbarComponent } from './menu/navbar/navbar.component';
import {MatToolbar} from "@angular/material/toolbar";
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import { DatatableComponent } from './component/datatable/datatable.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    DatatableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbar,
    MatButton,
    MatIcon,
    MatIconButton
  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
