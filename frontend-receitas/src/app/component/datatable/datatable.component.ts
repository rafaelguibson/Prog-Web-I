import {Component, OnInit} from '@angular/core';
import {Receita} from "../../models/receita";
import {ReceitaHttpclienteService} from "../../service/receita-httpcliente.service";

@Component({
  selector: 'app-datatable',
  templateUrl: './datatable.component.html',
  styleUrl: './datatable.component.css'
})
export class DatatableComponent implements OnInit{
  displayedColumns: string[] = ['id', 'nome', 'ingredientes', 'modoPreparo', 'tempoPreparo', 'rendimento', 'categoria', 'acoes'];
  dataSource: Receita[] = [];

  constructor(private receitaService: ReceitaHttpclienteService) { }

  ngOnInit(): void {
    this.receitaService.listarTodos().subscribe((data: Receita[]) => {
      this.dataSource = data;
    });
  }
}
