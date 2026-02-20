import { Component, inject, output, signal } from '@angular/core';
import { Material } from '../../models/material.model';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MaterialService } from '../../services/material-service';

@Component({
  selector: 'app-material-form',
  imports: [ReactiveFormsModule],
  templateUrl: './material-form.html',
  styleUrl: './material-form.scss',
})
export class MaterialForm {

  private readonly _materialService = inject(MaterialService);

  materialsList= signal<Material[]>([]);
  materialCreated = output<void>();

  materialForm = new FormGroup({
    code: new FormControl('', { validators: [Validators.required], nonNullable: true }),
    name: new FormControl('', { validators: [Validators.required], nonNullable: true }),
    stockQuantity: new FormControl<number>(1, { validators: [Validators.required, Validators.min(1)], nonNullable: true })
  });

  ngOnInit(): void {
    this.returnAllMaterials();
  }

  saveMaterial() {
    if (this.materialForm.valid) {
      const payload = this.materialForm.getRawValue();

      this._materialService.save(payload).subscribe({
        next: () => {
          this.materialForm.reset();
          this.materialCreated.emit();
          alert('Matéria-prima cadastrada!');
        },
        error: (err) => alert('Erro ao salvar material')
      });
    }
  }

  returnAllMaterials() {
    this._materialService.findAll().subscribe({
      next: (data) => {
        this.materialsList.set(data);
      }
    });
  }
}
