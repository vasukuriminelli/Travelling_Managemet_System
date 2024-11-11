import { Component } from '@angular/core';

import { MyService } from 'src/app/services/my.service';
import { Route,Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {




  constructor(private service:MyService,private _formBuilder: FormBuilder,
    private _router:Router) {

  }

  pattern="[a-z0-9]+@[a-z]+\.[a-z]{2,3}"
  SRegExp = "/^(?=.[0-9])(?=.[!@#$%^&])[a-zA-Z0-9!@#$%^&]{6,16}$/";

  registerForm2= this._formBuilder.group({

    email: ['',[Validators.required,Validators.pattern(this.pattern)]],
     password: ['',[Validators.required, Validators.minLength(5)/*Validators.pattern("^(?=.[a-z])(?=.[A-Z])(?=.[0-9])(?=.[$@$!%?&])[A-Za-z\d$@$!%?&].{8,}$")*/]],
     repeatpassword:['',[Validators.required]]
  });
 

  postData(){
    
    this.service.addUser(this. registerForm2.value).subscribe(
      (res)=>{
        alert("User Added ")
      }
    )
  }

  get email(){
    return this.registerForm2.get('email')
  }

  get password(){
    return this.registerForm2.get('password')
  }

  get repeatpassword(){
    return this.registerForm2.get('repeatpassword')
  }

}




