import { Component, OnInit, Input } from '@angular/core';
import { Flujo } from '../model/flujo';

@Component({
  selector: 'app-flujo-details',
  templateUrl: './flujo-details.component.html',
  styleUrls: ['./flujo-details.component.css']
})
export class FlujoDetailsComponent implements OnInit {

  @Input() flujo: Flujo;
  constructor() { }

  ngOnInit() {
  }

}
