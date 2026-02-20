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
  private readonly _productService = inject(ProductService);

  productsList = signal<Product[]>([]);
  error = signal<string | null>(null);

  ngOnInit() {
    this.returnsAllProducts();
  }

  returnsAllProducts() {
    this._productService.findAll().subscribe({
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

  onDelete(id: number): void{
    if (confirm('Deseja realmente excluir este produto?')) {
      
      this._productService.delete(id).subscribe({
        next: () => {
          this.returnsAllProducts();
          alert('Produto removido com sucesso!');
        },
        error: (err) => {
          console.error('Erro ao excluir:', err);
          alert('Não foi possível excluir o produto.');
        }
      });
    }
  }
}
