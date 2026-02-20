import { CommonModule } from '@angular/common';
import { Component, inject, output, signal } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import { ProductService } from '../../services/product-service';
import { Product } from '../product/product';
import { MaterialService } from '../../../materials/services/material-service';
import { Material } from '../../../materials/models/material.model';

@Component({
  selector: 'app-product-form',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './product-form.html',
  styleUrl: './product-form.scss',
})
export class ProductForm {

  private readonly _productService = inject(ProductService);
  private readonly _rawMaterialService = inject(MaterialService);

  materialsList= signal<Material[]>([]);
  productSaved = output<void>();

  productForm = new FormGroup({
    code: new FormControl('', { validators: [Validators.required], nonNullable: true }),
    name: new FormControl('', { validators: [Validators.required], nonNullable: true }),
    price: new FormControl<number | null>(null, { validators: [Validators.required], nonNullable: true }),
    materialId: new FormControl<number | null>(null, { validators: [Validators.required], nonNullable: true }),
    requiredQuantity: new FormControl<number>(1, { validators: [Validators.required], nonNullable: true })
  });

  ngOnInit(): void {
    this.returnAllMaterials();
  }

  saveProduct() {
    if (this.productForm.valid) {
      const form = this.productForm.getRawValue();

      const payload: Partial<Product> = {
      code: form.code.trim(),
      name: form.name.trim(),
      price: form.price,
      materials: [
        {
          rawMaterialId: form.materialId as number,
          requiredQuantity: form.requiredQuantity
        }
      ]
    };
      
      this._productService.save(payload).subscribe({
        next: () => {
          this.productForm.reset();
          this.productSaved.emit();
          alert('Produto cadastrado com sucesso!');
        }
      });
    }
  }

  returnAllMaterials() {
    this._rawMaterialService.findAll().subscribe({
      next: (data) => {
        this.materialsList.set(data);
      }
    });
  }
}
