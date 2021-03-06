import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RootLayoutPageComponent } from './pages/root-layout-page/root-layout-page.component';
import { SharedModule } from '../shared/shared.module';
import { HeaderCommonComponent } from './components/header/header-common/header-common.component';
import { MaterialExampleModule } from 'src/material.module';
import { RegistrationComponent } from './components/registration/registration.component';
import { RegistrationPageComponent } from './pages/registration-page/registration-page.component';
import { AuthModule } from '../auth/auth.module';
import { HeaderCitizenComponent } from './components/header/header-citizen/header-citizen.component';
import { HeaderDoctorComponent } from './components/header/header-doctor/header-doctor.component';
import { UserDocsModule } from '../user-docs/user-docs.module';

@NgModule({
    declarations: [
        AppComponent,
        RootLayoutPageComponent,
        HeaderCommonComponent,
        RegistrationComponent,
        RegistrationPageComponent,
        HeaderCitizenComponent,
        HeaderDoctorComponent
    ],
    imports: [
        CommonModule,
        BrowserModule,
        BrowserAnimationsModule,
        AppRoutingModule,
        AuthModule,
        MaterialExampleModule,
        FormsModule,
        HttpClientModule,
        UserDocsModule,
        // ToastrModule.forRoot(),
        SharedModule,
        ReactiveFormsModule,
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
