import { Component, inject, signal } from '@angular/core';
import { MaterialService } from '../../services/material-service';
import { Material } from '../../models/material.model';

@Component({
  selector: 'app-material-list',
  imports: [],
  templateUrl: './material-list.html',
  styleUrl: './material-list.scss',
})
export class MaterialList {

  private readonly _rawMaterialService = inject(MaterialService);

  materialsList= signal<Material[]>([]);
  error = signal<string | null>(null);

  ngOnInit(): void {
    this.returnAllMaterials();
  }

  returnAllMaterials() {
    this._rawMaterialService.findAll().subscribe({
      next: (data) => {
        this.materialsList.set(data);
      }
    });
  }

  onEdit(): void{
  }
  
  onDelete(id: number): void{
    if (confirm('Deseja realmente excluir este material?')) {
        
      this._rawMaterialService.delete(id).subscribe({
        next: () => {
          this.returnAllMaterials();
          alert('Material removido com sucesso!');
        },
        error: (err) => {
          console.error('Erro ao excluir:', err);
          alert('Não foi possível excluir o produto.');
        }
      });
    }
  }
}
