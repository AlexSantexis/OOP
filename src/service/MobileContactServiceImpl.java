package service;

import DesignPatterns.ch1.Model.MobileContact;
import DesignPatterns.ch1.Model.UserDetails;
import Exceptions.ContactNotFoundException;
import Exceptions.PhoneNumberAlreadyExistsException;
import Exceptions.UserIdAlreadyExistsException;
import dao.IMobileContactDAO;
import dto.MobileConctactInsertDTO;
import dto.MobileContactUpdateDTO;
import dto.UserDetailsInsertDTO;
import dto.UserDetailsUpdateDTO;

import java.util.List;

public class MobileContactServiceImpl implements IMobileContactService {
    private final IMobileContactDAO dao;

    public MobileContactServiceImpl(IMobileContactDAO dao) {
        this.dao = dao;
    }

    @Override
    public MobileContact insertMobileContact(MobileConctactInsertDTO mobileConctactInsertDTO) throws PhoneNumberAlreadyExistsException, UserIdAlreadyExistsException {
        MobileContact mobileContact;
        try {
            mobileContact = new MobileContact();
            mapInsertMobileContact(mobileContact, mobileConctactInsertDTO);
            if (dao.phoneNumberExists(mobileContact.getPhoneNumber())) {
                throw new PhoneNumberAlreadyExistsException(mobileContact);
            }
            if (dao.userIdExists(mobileContact.getId())) {
                throw new UserIdAlreadyExistsException(mobileContact);
            }
            return dao.insert(mobileContact);
        } catch (PhoneNumberAlreadyExistsException | UserIdAlreadyExistsException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public MobileContact updateContact(MobileContactUpdateDTO mobileContactUpdateDTO) throws PhoneNumberAlreadyExistsException, ContactNotFoundException {
        MobileContact mobileContact;
        try {
            mobileContact = new MobileContact();
            mapUpdateMobileContact(mobileContact, mobileContactUpdateDTO);
            if (dao.phoneNumberExists(mobileContact.getPhoneNumber())) {
                throw new PhoneNumberAlreadyExistsException(mobileContact);
            }
            if (!dao.userIdExists(mobileContact.getId())) {
                throw new ContactNotFoundException(mobileContact);
            }
            return dao.update(mobileContact);
        } catch (PhoneNumberAlreadyExistsException | ContactNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteContactById(Long id) throws ContactNotFoundException {
        try {
            if (!dao.userIdExists(id)) {
                throw new ContactNotFoundException(id);
            }
            dao.delete(id);
        } catch (ContactNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public MobileContact getContact(Long id) throws ContactNotFoundException {
        MobileContact mobileContact;
        try {
            mobileContact = dao.get(id);
            if (mobileContact == null) {
                throw new ContactNotFoundException(id);
            }
            return mobileContact;
        } catch (ContactNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<MobileContact> getAllContacts() {
        return dao.getAll();
    }

    @Override
    public MobileContact getContact(String phoneNumber) throws ContactNotFoundException {
        MobileContact mobileContact;
        try {
            mobileContact = dao.get(phoneNumber);
            if (mobileContact == null) {
                throw new ContactNotFoundException(phoneNumber);
            }
            return mobileContact;
        } catch (ContactNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteContact(String phoneNumber) throws ContactNotFoundException {
        try {
            if (!dao.phoneNumberExists(phoneNumber)) {
                throw new ContactNotFoundException(phoneNumber);
            }
            dao.delete(phoneNumber);
        } catch (ContactNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void mapInsertMobileContact(MobileContact mobileContact, MobileConctactInsertDTO mobileConctactInsertDTO) {
        mobileContact.setId(mobileConctactInsertDTO.getId());
        mobileContact.setPhoneNumber(mobileConctactInsertDTO.getPhoneNumber());
        UserDetails userDetails = new UserDetails();
        mapUserDetails(userDetails, mobileConctactInsertDTO.getUserDetailsInsertDTO());
        mobileContact.setUserDetails(userDetails);
    }

    private void mapUpdateMobileContact(MobileContact mobileContact, MobileContactUpdateDTO mobileContactUpdateDTO) {
        mobileContact.setId(mobileContactUpdateDTO.getId());
        mobileContact.setPhoneNumber(mobileContactUpdateDTO.getPhoneNumber());
        UserDetails userDetails = new UserDetails();
        mapUserDetails(userDetails, mobileContactUpdateDTO.getUserDetailsUpdateDTO());
        mobileContact.setUserDetails(userDetails);
    }

    private void mapUserDetails(UserDetails userDetails, UserDetailsInsertDTO userDetailsInsertDTO) {
        userDetails.setId(userDetailsInsertDTO.getId());
        userDetails.setFirstName(userDetailsInsertDTO.getFirstname());
        userDetails.setLastName(userDetailsInsertDTO.getLastname());
    }

    private void mapUserDetails(UserDetails userDetails, UserDetailsUpdateDTO userDetailsUpdateDTO) {
        userDetails.setId(userDetailsUpdateDTO.getId());
        userDetails.setFirstName(userDetailsUpdateDTO.getFirstname());
        userDetails.setLastName(userDetailsUpdateDTO.getLastname());
    }

}

