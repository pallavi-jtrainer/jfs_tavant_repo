import { AbstractControl, ValidatorFn } from "@angular/forms";

export default class PasswordValidation {
  static match(controlName: string, checkControl: string): ValidatorFn {
    return (controls: AbstractControl) => {
      const passwordControl = controls.get(controlName);
      const checkControlValue = controls.get(checkControl);

      if(checkControlValue?.errors && !checkControlValue.errors['matching']) {
        return null;
      }

      if(passwordControl?.value !== checkControlValue?.value) {
        controls.get(checkControl)?.setErrors({'matching': true});
        return {'matching': true};
      } else {
        return null;
      }
    };
  }
}
