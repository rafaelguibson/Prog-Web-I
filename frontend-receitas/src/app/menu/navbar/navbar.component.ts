import { Component } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {RegisterDialogComponent} from "../../component/register-dialog/register-dialog.component";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  constructor(public dialog: MatDialog) {}

  openDialog(): void {
    this.dialog.open(RegisterDialogComponent, {
      width: '800px',
      height: '500px'
    });
  }
}
