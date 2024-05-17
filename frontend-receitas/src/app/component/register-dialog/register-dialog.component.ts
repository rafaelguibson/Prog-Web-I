import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Receita} from "../../models/receita";
import {FormBuilder, FormGroup, UntypedFormGroup, Validators} from "@angular/forms";
import {ReceitaHttpclienteService} from "../../service/receita-httpcliente.service";

@Component({
  selector: 'app-register-dialog',
  templateUrl: './register-dialog.component.html',
  styleUrl: './register-dialog.component.css'
})
export class RegisterDialogComponent implements OnInit{
  receitasForm!: FormGroup;
  form!: UntypedFormGroup;
  constructor(
    public dialogRef: MatDialogRef<RegisterDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Receita,
    private formBuilder: FormBuilder,
    private receitaService: ReceitaHttpclienteService
  ) {}

  ngOnInit() {
    this.receitasForm = this.formBuilder.group({
      id: [''],
      nome: [''],
      ingredientes: ['', [Validators.required]],
      modoPreparo: ['', [Validators.required]],
      tempoPreparo: ['', [Validators.required]],
      rendimento: ['', [Validators.required]],
      categoria: ['', [Validators.required]],
    });
  }

  onSubmit(): void {
    if (this.receitasForm.valid) {
      const receita: Receita = this.receitasForm.value;
      this.receitaService.salvar(receita).subscribe({
        next: (result) => {
          console.log('Receita salva com sucesso:', result);
          // Lógica adicional, como redirecionar para outra página
        },
        error: (err) => {
          console.error('Erro ao salvar a receita:', err);
          // Tratamento de erro, como exibir uma mensagem de erro para o usuário
        }
      });
    }
  }

  onCancel(): void {
    this.receitasForm.reset();
  }


  fecharModal(): void {
    this.dialogRef.close();
  }
}
