import { Component, inject, signal } from '@angular/core';
import { ProductService } from '../../services/product-service';
import { Product } from '../../models/product.model';

@Component({
  selector: 'app-product-list',
  imports: [],
  templateUrl: './product-list.html',
  styleUrl: './product-list.scss',
})
export class ProductList {
  private readonly _service = inject(ProductService);

  productsList = signal<Product[]>([]);
  error = signal<string | null>(null);

  ngOnInit() {
    this.returnsAllProducts();
  }

  returnsAllProducts() {
    this._service.findAll().subscribe({
      next: (data) => {
        this.productsList.set(data);
      },
      error: (err) => {
        console.error('Erro ao carregar produtos: ' + err);
      }
    });
  }

  onEdit(): void{
  }

  onDelete(): void{
  }
}
