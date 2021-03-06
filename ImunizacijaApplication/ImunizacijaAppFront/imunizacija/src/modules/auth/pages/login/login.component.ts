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
        //todo srediti
        if (role === "CITIZEN")
          this.router.navigate(["imunizacija-app/interesovanje/novo-interesovanje"]);
        if (role === "DOCTOR")
          this.router.navigate(["imunizacija-app/saglasnost/drugi-deo-saglasnosti"]);
        // }
        // else if (role === "MANAGER") {
        //   this.router.navigate(["rest-app/employees/employees-manager"]);
        // }
        // else if (role === "COOK") {
        //   this.router.navigate(["rest-app/orders/orders-page"]);
        // }
        // else if (role === "HEAD_COOK") {
        //   this.router.navigate(["rest-app/orders/orders-page"]);
        // }
        // else if (role === "BARMAN") {
        //   this.router.navigate(["rest-app/orders/orders-page"]);
        // }
        // else if (role === "WAITER") {
        //   this.router.navigate(["rest-app/tables/tables-waiter"]);
        // }
      }
    },
      (err) => {
        if (err.status === 401)
          this.snackBarService.openSnackBar("Bad credentials.");
      }
    );
  }
}
