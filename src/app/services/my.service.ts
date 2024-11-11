import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MyService {

  private _url="http://localhost:8080/"
 
  constructor(private _http:HttpClient) { }

  public insert(data):Observable<any>{
    return this._http.post(this._url+"insert",data)
  }
  public insertbookings(data):Observable<any>{
    return this._http.post(this._url+"insertbooking",data)
  }
public getbookings():Observable<any>{
  return this._http.get(this._url+"getdetails")
}
public updatebooking(data){
  return this._http.put(this._url+"updatedetails",data,{responseType:"text"});
}
public deletebooking(data){
  return this._http.delete(this._url+"deletebooking/"+data,{responseType:"text"});
}


//login

public addUser(data):Observable<any>{
  return this._http.post(this._url +"signup",data)
}

public checkUser(email:any, password:any):Observable<any>{
  return this._http.get(this._url +"check/"+ email +"/"+ password,{responseType:'text'})
}
}
