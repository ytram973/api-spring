import { Component, inject } from '@angular/core';
import { toSignal } from '@angular/core/rxjs-interop';
import { ProduitService } from '../services/produit';

@Component({
  selector: 'app-produits',
  template: `
    <h1>Formations</h1>
    <ul>
      @for (t of trainings(); track t.id) {
        <li>
          <strong>{{ t.name }}</strong> : {{ t.description }}
          ({{ t.price }} € - quantité : {{ t.quantity }})
        </li>
      }
    </ul>
  `
})
export class ProduitsComponent {
  private service = inject(ProduitService);
  trainings = toSignal(this.service.getAll(), { initialValue: [] });
}