package com.zyu.expulsion.submit.form.service;

import com.zyu.expulsion.submit.form.dao.SignUpDao;
import com.zyu.expulsion.submit.form.dto.FormSubmitRequest;
import com.zyu.expulsion.submit.form.model.SignUpForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private SignUpDao signUpDao;

    @Override
    public void save(FormSubmitRequest signUpForm) {

        SignUpForm form = new SignUpForm();
        form.setCreatedDatetime(new Date());
        form.setLandlordName(signUpForm.getLandLordName());
        form.setLandlordCity(signUpForm.getLandlordCity());
        form.setLandlordState(signUpForm.getLandlordState());
        form.setLandlordZip(signUpForm.getLandlordZip());
        form.setLandlordCounty(signUpForm.getLandlordCounty());
        form.setLandlordTelephone(signUpForm.getLandlordTelephone());
        form.setLandLordEmail(signUpForm.getLandLordEmail());
        form.setTenant1(signUpForm.getTenant1());
        form.setTenant2(signUpForm.getTenant2());
        form.setTenant3(signUpForm.getTenant3());
        form.setTenant4(signUpForm.getTenant4());
        form.setTenantAddress(signUpForm.getTenantAddress());
        form.setTenantCity(signUpForm.getTenantCity());
        form.setTenantState(signUpForm.getTenantState());
        form.setTenantZip(signUpForm.getTenantZip());
        form.setTenantCounty(signUpForm.getTenantCounty());
        form.setTenantTelephone(signUpForm.getTenantTelephone());
        form.setTenantEmail(signUpForm.getTenantEmail());
        signUpDao.save(form);
    }
}
