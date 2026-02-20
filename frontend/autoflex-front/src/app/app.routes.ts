import { Routes } from '@angular/router';
import { MainLayout } from './layout/main-layout/main-layout';
import { Product } from './features/products/pages/product/product';
import { Material } from './features/materials/pages/material/material';


export const routes: Routes = [
    {path: '', 
        component: MainLayout, 
        children:[
            {path: '', redirectTo: 'products', pathMatch: 'full' },
            {path: 'products', component: Product},
            {path: 'materials', component: Material},
        ]},
];
