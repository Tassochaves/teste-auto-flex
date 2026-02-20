import { Routes } from '@angular/router';
import { MainLayout } from './layout/main-layout/main-layout';
import { MaterialList } from './features/materials/pages/material-list/material-list';
import { Product } from './features/products/pages/product/product';


export const routes: Routes = [
    {path: '', 
        component: MainLayout, 
        children:[
            {path: '', redirectTo: 'products', pathMatch: 'full' },
            {path: 'products', component: Product},
            {path: 'materials', component: MaterialList},
        ]},
];
