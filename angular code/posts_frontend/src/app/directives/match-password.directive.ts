import { Directive, Input } from '@angular/core';
import { AbstractControl, FormGroup, NG_VALIDATORS, ValidationErrors, Validator } from '@angular/forms';
import PasswordValidation from '../utils/passwordvalidation';

@Directive({
  selector: '[appMatchPassword]',
  providers: [{ provide: NG_VALIDATORS, useExisting: MatchPasswordDirective, multi: true}]
})
export class MatchPasswordDirective implements Validator{

  @Input('appMatchPassword') matchPassword: string[] = [];

  validate(formGroup: FormGroup): ValidationErrors | null {
    return PasswordValidation.match(this.matchPassword[0], this.matchPassword[1])(formGroup);
  }

}
