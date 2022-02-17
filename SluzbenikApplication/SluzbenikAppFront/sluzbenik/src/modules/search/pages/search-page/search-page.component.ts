import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DocumentProviderService } from 'src/modules/shared/services/document-provider.service';
import { SnackBarService } from 'src/modules/shared/services/snack-bar.service';
import { UtilService } from 'src/modules/shared/services/util.service';
import { SearchResults } from '../../models/search-results';
import { SearchService } from '../../services/search-service';

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.scss']
})
export class SearchPageComponent implements OnInit {

  registrationFormGroup: FormGroup;
  searchResults: SearchResults | undefined;

  constructor(private fb: FormBuilder, private snackBarService: SnackBarService,
              private searchService: SearchService, private utilService: UtilService,
              private documentProviderService: DocumentProviderService) { 

    this.registrationFormGroup = this.fb.group({
      documentType: ['Saglasnost', Validators.required],
      userId: [''],
      searchText: [''],
    });
  }

  ngOnInit(): void {
  }

  get f() {
    return this.registrationFormGroup.controls;
  }

  checkSubmit() {
    return !this.registrationFormGroup.valid;
  }

  private resetStateOfForm() {
    this.registrationFormGroup = this.fb.group({
      documentType: ['Saglasnost', Validators.required],
      userId: [''],
      searchText: [''],
    });
  }

  search() {
    let userId: string = this.registrationFormGroup.get('userId')?.value;
    let searchText: string = this.registrationFormGroup.get('searchText')?.value;
    let documentType: string = this.registrationFormGroup.get('documentType')?.value;

    this.searchService.basicSearch(userId, searchText, documentType.toLowerCase()).subscribe((response) => {
      let res = this.searchService.parseXml(response.body as string);

      if(res.Search_results !== '') 
        this.searchResults = res;
      else
        this.searchResults = undefined;
      
      if(!this.searchResults) 
        this.snackBarService.openSnackBarFast("Nema rezultata za unetu pretragu");

      console.log(this.searchResults);
    },
    (error) => {
      this.snackBarService.openSnackBarFast("Doslo je do greške prilikom pretrage..");
    })
  }

  getPdf(documentId: any) {
    let documentName: string = this.registrationFormGroup.get('documentType')?.value.toLowerCase();

    this.documentProviderService.getDocumentPDF(documentName, documentId).subscribe((response) => {
      if(response.body)
        this.utilService.downloadPDFDocument(response.body, documentName);
    }, 
    (error) => {
      this.snackBarService.openSnackBarFast("Doslo je do greške prilikom preuzimanja/prikazivanja dokumenta.");
    });
  }
  
  getHtml(documentId: any) {
    let documentName: string = this.registrationFormGroup.get('documentType')?.value.toLowerCase();

    this.documentProviderService.getDocumentHTML(documentName, documentId).subscribe((response) => {
      if(response.body)
        this.utilService.openHtmlDocumentInNewTab(response.body);
    }, 
    (error) => {
      this.snackBarService.openSnackBarFast("Doslo je do greške prilikom prikazivanja dokumenta.");
    });
  }

}