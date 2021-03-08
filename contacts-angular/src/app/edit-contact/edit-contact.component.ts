import {Component, OnInit} from '@angular/core';
import {ContactService} from '../service/contact.service';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import {Contact} from '../model/Contact';

@Component({
  selector: 'app-edit-contact',
  templateUrl: './edit-contact.component.html',
  styleUrls: ['./edit-contact.component.css']
})
export class EditContactComponent implements OnInit {

  contact: Contact = {};

  constructor(private contactService: ContactService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.contactService.getContact(id).subscribe(data => this.contact = data);
  }

  onSave(): void {
    this.contactService.editContact(this.contact).subscribe(
      (_) => this.location.back()
    );
  }

  onCancel(): void {
    this.location.back();
  }

}
