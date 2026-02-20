import { Component } from '@angular/core';
import { MaterialForm } from "../material-form/material-form";
import { MaterialList } from "../material-list/material-list";

@Component({
  selector: 'app-material',
  imports: [MaterialForm, MaterialList],
  templateUrl: './material.html',
  styleUrl: './material.scss',
})
export class Material {

}
