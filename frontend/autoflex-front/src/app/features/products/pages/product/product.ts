import { Component } from '@angular/core';
import { ProductForm } from "../product-form/product-form";
import { ProductList } from "../product-list/product-list";

@Component({
  selector: 'app-product',
  imports: [ProductForm, ProductList],
  templateUrl: './product.html',
  styleUrl: './product.scss',
})
export class Product {

}
