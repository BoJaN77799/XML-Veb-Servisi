import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators, FormControl } from "@angular/forms";
import { Router } from "@angular/router";
import { JwtHelperService } from "@auth0/angular-jwt";
import { Login } from "src/modules/shared/models/login";
import { SnackBarService } from "src/modules/shared/services/snack-bar.service";
import { AuthService } from "../../services/auth-service/auth.service";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.scss"],
})
export class LoginComponent {
  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router,
    private snackBarService: SnackBarService
  ) {
    this.form = this.fb.group({
      username: [null, Validators.required],
      password: [null, Validators.required],
    });
  }

  submit() {
    const auth: Login = {
      authentication: {
        username: this.form.value.username,
        password: this.form.value.password
      }
    };

    this.authService.login(auth).subscribe((result) => {
      if (result.body) {
        this.snackBarService.openSnackBar("Successful login!");

        const token = this.authService.tokenRespfromXMLToJSON(result.body);
        localStorage.setItem("user", token);

        const jwt: JwtHelperService = new JwtHelperService();
        const info = jwt.decodeToken(token);
        const role = info.role;
        //todo srediti - staviti da ide na komponentu redirect
        
        if (role === "MEDICAL_OFFICIAL") {
          this.router.navigate(["sluzbenik-app/vakcina/status-vakcina"])
        }
      }
    },
      (err) => {
        if (err.status === 401)
          this.snackBarService.openSnackBar("Bad credentials.");
      }
    );
  }
}
