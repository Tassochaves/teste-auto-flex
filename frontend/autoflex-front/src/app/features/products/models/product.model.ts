import { ProductMaterial } from "./product-material.model";

export interface Product {
    id: number;
    code: string;
    name: string;
    price: number;
    materials: ProductMaterial[];
}