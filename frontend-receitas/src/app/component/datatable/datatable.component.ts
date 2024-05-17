import {Component, OnInit} from '@angular/core';
import {Receita} from "../../models/receita";
import {ReceitaHttpclienteService} from "../../service/receita-httpcliente.service";
import {DialogDeleteComponent} from "../dialog-delete/dialog-delete.component";
import {MatDialog} from "@angular/material/dialog";
import {RegisterDialogComponent} from "../register-dialog/register-dialog.component";
import {DialogSucessComponent} from "../dialog-sucess/dialog-sucess.component";

@Component({
  selector: 'app-datatable',
  templateUrl: './datatable.component.html',
  styleUrl: './datatable.component.css'
})
export class DatatableComponent implements OnInit{
  displayedColumns: string[] = ['id', 'nome', 'ingredientes', 'modoPreparo', 'tempoPreparo', 'rendimento', 'categoria', 'acoes'];
  dataSource: Receita[] = [];

  constructor(private receitaService: ReceitaHttpclienteService,public dialog:MatDialog,) { }

  ngOnInit(): void {
    this.receitaService.listarTodos().subscribe((data: Receita[]) => {
      this.dataSource = data;
    });
  }

  openDialog(): void {
    const dialogRef =  this.dialog.open(RegisterDialogComponent, {
      width: '700px',
      height: '500px'
    });
    dialogRef.afterClosed().subscribe(result => {
      this.openDialogSucsess();
      this.receitaService.listarTodos().subscribe((data: Receita[]) => {
        this.dataSource = data;
      });
    });
  }

  openDialogSucsess() {
    const dialogRef = this.dialog.open(DialogSucessComponent,
      {
        height: '150px',
        width: '400px',
      });
  }

  openDialogDelete(receita: Receita) {
    const dialogRef = this.dialog.open(DialogDeleteComponent,
      {
        height: '200px',
        width: '400px',
        data: {receita}
      });

    dialogRef.afterClosed().subscribe(result => {
      this.receitaService.listarTodos().subscribe((data: Receita[]) => {
        this.dataSource = data;
      });
    });
  }


  openDialogEdit(receita: Receita) {
    this.dialog.open(RegisterDialogComponent, {
      width: '700px',
      height: '500px',
      data: receita
    });
  }
}
