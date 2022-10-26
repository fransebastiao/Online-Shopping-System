import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonService } from 'src/app/common.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public login:any=FormGroup;
  users:any = [];

  //constructor(private fb:FormBuilder,private router:Router,private comserve:CommonService) { }
  
  constructor( private fb:FormBuilder,private router:Router) { }

  ngOnInit(): void {

    this.login = this.fb.group({
      name:['',Validators.required],
      email:['',Validators.compose([Validators.required,Validators.email])]
    })
   
    
  }


//This will read the data without server//will only confirm the data given with this ones in the code.
loginform(data:any)
{
  //if (item.name === data.name && item.email === data.email)
if (data.name === "ADP" && data.email === "adp.mycput.ac.za")
{
//console.log("User Is valid")

this.router.navigate(['admhome']) 

}
}


//This will read the data from server
loginSubmit(data:any)
{
if(data.name)
{
  this.users.forEach((item:any)=>
  {

    if (item.name === data.name && item.email === data.email)
    {
      this.router.navigate(['register'])
    }
   // else{console.log("User Is Not valid")}
  // localStorage.clear();

  });
}
}
goToRegister(){
this.router.navigate(['register'])
}



}
