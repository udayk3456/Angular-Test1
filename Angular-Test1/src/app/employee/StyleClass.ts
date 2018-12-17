import {Component} from '@angular/core';
@Component({
selector: 'app-style-class',
template: `
<button style='color:red' [disabled]='isDisabled'>Uday</button>
<br>
<button class='colorClass' [class]='classesToApply'>ClassButton</button>
<br/>
<button [class.boldClass]='isBoldClass'>BoldClass</button>
<br/>
<button [ngClass]='addClass()'>NgClass</button>
<br/>
<button style='color:red' [style.font-weight]="isBold ? 'bold':'normal'" [style.font-size.px]="fontSize">StyleBinding</button>
`,
/*styles: [`
button{font-weight:bold,color:red;}
`
]*/
styleUrls: ['StyleClass.css']
})
export class StylesClassComponent {
isBold: Boolean = true;
fontSize = 20;
isDisabled = true;
classesToApply: String = 'boldClass italiClass';
isBoldClass: Boolean = true;
isItalicClass: Boolean = true;

addClass() {
// tslint:disable-next-line:prefer-const
let classes = {
boldClass: this.isBoldClass ,
italiClass: this.isItalicClass
};
return classes;
}
}
