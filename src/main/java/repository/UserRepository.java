package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.User;

@Repository("userRepository")
public class UserRepository{
	@PersistenceContext
    private EntityManager entityManager;
 
    public User selectUserById(long userId) {
        return entityManager.find(User.class, userId);
    }
 
    public void insertUser(User user) {
        entityManager.persist(user);
    }
 
    public void updateUser(User user) {
 
        User userToUpdate = selectUserById(user.getUserId());
 
        userToUpdate.setUserName(user.getUserName());
        userToUpdate.setUserEmail(user.getUserEmail());
        userToUpdate.setUserPhoneNo(user.getUserPhoneNo());
        userToUpdate.setUserDob(user.getUserDob());
        entityManager.flush();
    }
 
    public void deleteUser(long userId) {
        entityManager.remove(selectUserById(userId));
    }
 
    public List<User> selectAllUser() {
        Query query = entityManager.createQuery("from User as usr order by usr.userId");
        return (List<User>) query.getResultList();
    }
}
