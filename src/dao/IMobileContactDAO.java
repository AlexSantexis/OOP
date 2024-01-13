package dao;

import DesignPatterns.ch1.Model.MobileContact;

import java.util.List;

public interface IMobileContactDAO {
    MobileContact insert(MobileContact mobileContact);

    MobileContact update(MobileContact mobileContact);

    void delete(Long id);

    MobileContact get(Long id);

    List<MobileContact> getAll();

    MobileContact get(String phoneNumber);

    boolean phoneNumberExists(String phoneNumber);

    boolean userIdExists(Long id);

    void delete(String phoneNumber);
}
