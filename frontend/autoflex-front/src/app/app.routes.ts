import { Routes } from '@angular/router';
import { ProductList } from './features/products/pages/product-list/product-list';
import { MainLayout } from './layout/main-layout/main-layout';
import { MaterialList } from './features/materials/pages/material-list/material-list';


export const routes: Routes = [
    {path: '', 
        component: MainLayout, 
        children:[
            {path: '', redirectTo: 'products', pathMatch: 'full' },
            {path: 'products', component: ProductList},
            {path: 'materials', component: MaterialList},
        ]},
];
