import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ReceitaHttpclienteService} from "../../service/receita-httpcliente.service";
import {Receita} from "../../models/receita";

@Component({
  selector: 'app-dialog-delete',
  templateUrl: './dialog-delete.component.html',
  styleUrl: './dialog-delete.component.css'
})
export class DialogDeleteComponent {
  constructor(public dialogRef: MatDialogRef<DialogDeleteComponent>,
              private httpService : ReceitaHttpclienteService,
              @Inject(MAT_DIALOG_DATA) public data: { receita: Receita },) {}


  fecharModal() {
    this.dialogRef.close();
  }

  deleteMonitorador(receita: Receita) {
    this.httpService.excluir(this.data.receita.id).subscribe(
      (response) => {
        console.log('Receita excluído com sucesso:', response);
      },
      (error) => {
        console.error('Erro ao excluir o monitorador:', error);
      }
    );
    this.dialogRef.close();
  }
}
