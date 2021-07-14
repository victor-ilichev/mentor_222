package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDaoInterface;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserService implements UserServiceInterface {

   @Autowired
   private UserDaoInterface userDao;

   @Override
   public void save(User user) {
      userDao.save(user);
   }

   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public User find(long id) {
      return userDao.find(id);
   }

   @Override
   public User findByEmail(String email) {
      return userDao.findByEmail(email);
   }

   @Override
   public void update(User user) {
      userDao.update(user);
   }

   @Override
   public void delete(User user) {
      userDao.delete(user);
   }
}
