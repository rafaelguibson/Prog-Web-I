import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ReceitaHttpclienteService} from "../../service/receita-httpcliente.service";
import {Receita} from "../../models/receita";

@Component({
  selector: 'app-dialog-sucess',
  templateUrl: './dialog-sucess.component.html',
  styleUrl: './dialog-sucess.component.css'
})
export class DialogSucessComponent {
  constructor(public dialogRef: MatDialogRef<DialogSucessComponent>,
              private httpService : ReceitaHttpclienteService,
              @Inject(MAT_DIALOG_DATA) public data: { receita: Receita },) {}

  fecharModal() {
    this.dialogRef.close();
  }
}
