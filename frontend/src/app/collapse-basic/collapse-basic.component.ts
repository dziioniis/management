import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-collapse-basic',
  templateUrl: './collapse-basic.component.html',
  styleUrls: ['./collapse-basic.component.css']
})
export class CollapseBasicComponent implements OnInit {
 isCollapsed = false;
  constructor() { }

public collapsed(event: any): void {
    console.log(event);
}

public expanded(event: any): void {
    console.log(event);
}


  ngOnInit() {
  }

}
