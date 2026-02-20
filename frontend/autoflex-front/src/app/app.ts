import { Component, signal } from '@angular/core';
import { MainLayout } from './layout/main-layout/main-layout';
import { RouterOutlet } from "@angular/router";

@Component({
  imports: [RouterOutlet],
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
}
