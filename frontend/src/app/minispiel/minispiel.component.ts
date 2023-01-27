import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MinispielService } from './minispiel.service';

@Component({
  selector: 'app-minispiel',
  templateUrl: './minispiel.component.html',
  styleUrls: ['./minispiel.component.scss']
})
export class MinispielComponent implements OnInit, AfterViewInit {

  counter: number;
  @ViewChild('ball') ball!: ElementRef;
  @ViewChild('outerContainer') container!: ElementRef;

  constructor(private service: MinispielService) { this.counter = 0; }

  ngOnInit(): void {
  }

  async ngAfterViewInit() {
    console.log(this.ball)

    var promiseFunc = (resolve: any) => {

      //EventListener Funktion
      var eventListenerFunc = () => {
        this.ball.nativeElement.style = "position:absolute; display: none;"
        this.counter++;
        console.log(this.counter);
        resolve("");
      }

      //10 Sekunden weg
      setTimeout(() => {
        var left = Math.random() * 465.0 + 5.0;
        var top = Math.random() * 465.0 + 5.0;
        this.ball.nativeElement.style = "position: absolute; left: " + left + "px; top: " + top + "px; width:25px"
        timeoutWaitForClick();
      }, 10000);

      //5 Sekunden da
      var timeoutWaitForClick = () => {
        let a = setTimeout(() => {
          this.ball.nativeElement.style = "position: absolute; display: none;";
          this.ball.nativeElement.removeEventListener("click", eventListenerFunc);
          resolve("");
        }, 5000);
      }

      //5 Sekunden abbrechen
      this.ball.nativeElement.addEventListener("click", eventListenerFunc, { once: true });

    }


    for (let i = 0; i < 5; i++) {
      await new Promise(promiseFunc);
    }

    this.service.addGeld(this.counter).subscribe();
    this.container.nativeElement.innerHTML = "<h1>Spiel vorbei: " + this.counter + " wurden gutgeschrieben</h1>"

  }
}
