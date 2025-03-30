package com.zyu.expulsion.submit.form.dao;
import com.zyu.expulsion.submit.form.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager em;

    @Override
    public List<User> findAllUsers() {
        TypedQuery<User> query = em.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public User getUser(String userName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.where(cb.equal(root.get("userName"), userName));

        return em.createQuery(query).getSingleResult();
    }

    @Override
    @Transactional
    public void saveUser(User user) throws SQLException {
        em.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(String userName) {
        User user = em.find(User.class, userName);
        if(user != null){
            em.remove(user);
        }
    }

//    private static final String SQL_QUERY = "select * from user";
//
//    @Override
//    public List<User> getUser(String userName) {
//        List<User> users = new ArrayList<>();
//        try (Connection con = DataSource.getConnection();
//             PreparedStatement pst = con.prepareStatement( SQL_QUERY );
//             ResultSet rs = pst.executeQuery();) {
//            User user;
//            while ( rs.next() ) {
//                user = new User();
//                user.setId(rs.getInt("id"));
//                user.setUserName(rs.getString("user_name"));
//                user.setEmail(rs.getString("email"));
//                user.setCreatedDate(rs.getDate("created_datetime"));
//                user.setModifiedDate(rs.getDate("modified_datetime"));
//                user.setLockedDate(rs.getDate("locked_datetime"));
//                user.setExpiredDate(rs.getDate("expired_datetime"));
//                user.setLastLoginDate(rs.getDate("last_login_datetime"));
//                user.setPasswordHash(rs.getString("password_hash"));
//                user.setStatus(rs.getString("status"));
//                user.setLoginAttempts(rs.getInt("login_attempts"));
//                users.add(user);
//            }
//        }catch(SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return users;
//    }

}

