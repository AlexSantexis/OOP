package service;

import DesignPatterns.ch1.Model.MobileContact;
import Exceptions.ContactNotFoundException;
import Exceptions.PhoneNumberAlreadyExistsException;
import Exceptions.UserIdAlreadyExistsException;
import dto.MobileConctactInsertDTO;
import dto.MobileContactUpdateDTO;

import java.util.List;

public interface IMobileContactService {
    MobileContact insertMobileContact(MobileConctactInsertDTO mobileConctactInsertDTO)
            throws PhoneNumberAlreadyExistsException, UserIdAlreadyExistsException;

    MobileContact updateContact(MobileContactUpdateDTO mobileContactUpdateDTO)
            throws PhoneNumberAlreadyExistsException, ContactNotFoundException;

    void deleteContactById(Long id) throws ContactNotFoundException;

    MobileContact getContact(Long id) throws ContactNotFoundException;

    List<MobileContact> getAllContacts();

    MobileContact getContact(String phoneNumber) throws ContactNotFoundException;

    void deleteContact(String phoneNumber) throws ContactNotFoundException;


}
