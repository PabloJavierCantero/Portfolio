import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtDto } from '../model/jwt-dto';
import { LoginUser } from '../model/login-user';
import { NewUser } from '../model/new-user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authURL = 'https://bkdportfolio.herokuapp.com/auth/';

  constructor(private httpClient: HttpClient) { }

  public newUser(nuevoUsuario: NewUser): Observable<any>{
    return this.httpClient.post<any>(this.authURL + 'new', nuevoUsuario);      
  }

  public login(loginUsuario: LoginUser): Observable<JwtDto>{
    return this.httpClient.post<JwtDto>(this.authURL + 'login', loginUsuario);
  }
}
