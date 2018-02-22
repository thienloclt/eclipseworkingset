import {Injectable} from '@angular/core';

@Injectable()
export class Globals {
  public theme = Themes.YELLOW;
}

enum Themes {
  RED = 'danger',
  BLUE = 'info',
  GREEN = 'success',
  YELLOW = 'warning'
}
