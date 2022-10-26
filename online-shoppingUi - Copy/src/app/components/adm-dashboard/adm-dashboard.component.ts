import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Product } from '../product';
import { ProductService } from '../productService';

@Component({
  selector: 'app-adm-dashboard',
  templateUrl: './adm-dashboard.component.html',
  styleUrls: ['./adm-dashboard.component.css']
})
export class AdmDashboardComponent implements OnInit {
  public products: Product[] = [];
  public editProduct!: Product;
  public deleteProduct!: Product;

  constructor(private productService: ProductService)
  {
    this.productService = JSON.parse(localStorage.getItem('currentUser') || '{}');
  }

  ngOnInit(): void {
    this.getProduct();
  }

  //get all the employees
  public getProduct(): void {
    this.productService.getProduct().subscribe(
      (response: Product[]) => {
        this.products = response;
        console.log(this.products);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
/*add Product/when the user clicks on the button add product it will display a form

  public onAddProduct(addForm: NgForm): void {
    document.getElementById('add-employee-form').click();
    this.productService.addProduct(addForm.value).subscribe(
      (response: Product): void => {
        console.log(response);
        this.getProduct();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }*/
//Update products
  public onUpdateProduct(product: Product): void {
    this.productService.updateProduct(product).subscribe(
      (response: Product) => {
        console.log(response);
        this.getProduct();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteProduct(productId: number): void {
    this.productService.deleteProduct(productId).subscribe(
      (response: void) => {
        console.log(response);
        this.getProduct();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  
  //When click on a button
  public onOpenModal(product: Product, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addProductModal');
    }
    if (mode === 'edit') {
      this.editProduct = product;
      button.setAttribute('data-target', '#updateProductModal');
    }
    if (mode === 'delete') {
      this.deleteProduct = product;
      button.setAttribute('data-target', '#deleteProductModal');
    }
    container?.appendChild(button);
    button.click();
  }


}
