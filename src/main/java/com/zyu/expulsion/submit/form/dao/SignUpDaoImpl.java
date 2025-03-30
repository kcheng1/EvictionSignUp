package com.zyu.expulsion.submit.form.dao;

import com.zyu.expulsion.submit.form.model.SignUpForm;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SignUpDaoImpl implements SignUpDao {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public void save(SignUpForm signUpForm) {
        em.persist(signUpForm);
    }
}
