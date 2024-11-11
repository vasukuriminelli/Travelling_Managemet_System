import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MyService } from 'src/app/services/my.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent {
  
  
  constructor(private fb: FormBuilder,private service:MyService) {  }

  registrationForm = this.fb.group({
    ID:[''],
    fromDestination: ['', Validators.required],
    toDestination: ['', Validators.required],
    price: ['', [Validators.required, Validators.min(1)]],
    date: ['', Validators.required],
    terms: [false, Validators.requiredTrue],
    
  });




  onSubmit() {

    if (this.registrationForm.valid) {

      console.log('Form Submitted!', this.registrationForm.value);

      this.service.insertbookings(this.registrationForm.value).subscribe((res)=>{
        if(res){
          alert("resgistration sucessful")
        }
        else
        {
          alert("resgistration failed")
        }
      }
    )
    } else {
      console.log('Form is invalid');
    }
}

update(data){
  this.service.updatebooking(data).subscribe((res2)=>{
    if(res2){
      alert("update sucessfull")
    }
    else{
      alert("update not sucessfull")
    }
  })

  };
}

