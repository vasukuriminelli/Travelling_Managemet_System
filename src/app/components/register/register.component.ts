import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MyService } from 'src/app/services/my.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  registrationForm = new FormGroup({
    fName: new FormControl('', [Validators.required, Validators.minLength(2)]),
    lName: new FormControl('', [Validators.required, Validators.minLength(2)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    phone: new FormControl('', [Validators.required, Validators.pattern('^[0-9]*$')]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    cPass: new FormControl('', [Validators.required]),
    gender: new FormControl('', [Validators.required])
  });

  constructor(private _myservice:MyService){

  }
  // Function to handle form submission
  onSubmit() {
    if (this.registrationForm.valid) {
      console.log(this.registrationForm.value);
      this._myservice.insert(this.registrationForm.value).subscribe((res)=>{
        if(res){
          alert("Registration successful!");
        }else{
          alert("failed")
        }
      })     
    } else {
      alert("Please fill out the form correctly.");
    }
  }
}
