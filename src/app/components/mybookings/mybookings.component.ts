import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MyService } from 'src/app/services/my.service';

@Component({
  selector: 'app-mybookings',
  templateUrl: './mybookings.component.html',
  styleUrls: ['./mybookings.component.css']
})
export class MybookingsComponent {

  table;
 

  //UPDATION BUTTON RELATED FORM
  registrationForm = this.fb.group({
    id:[''],
    fromDestination: ['', Validators.required],
    toDestination: ['', Validators.required],
    
  });
  
constructor(private service:MyService,private fb: FormBuilder,private _router:Router){

}
ngOnInit(){
  this.service.getbookings().subscribe((res)=>{
    this.table=res;
  })

}


ondelete(data){
this.service.deletebooking(data).subscribe((res1)=>{
  if(res1){
alert("Deleted Sucessfully")
  }
  else{
    alert("record not deleted")
  }
});
}


c:boolean=false;
remo=true
updatedetails(data){
  this.service.updatebooking(data).subscribe((res2)=>{
    if(res2){
      alert("updated sucessfully")
      this.ngOnInit()
      this.remo=false
    }
    else{
      alert("update not sucessfull")
    }
  });
}
  }
 

