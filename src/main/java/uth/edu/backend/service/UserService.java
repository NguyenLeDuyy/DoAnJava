package uth.edu.backend.service;

import org.springframework.stereotype.Service;
import uth.edu.backend.api.model.Register;
import uth.edu.backend.exception.UserAlreadyExistsException;
import uth.edu.backend.model.User;
import uth.edu.backend.model.dao.UserDAO;

@Service
public class UserService {

    private UserDAO userDao;

    public UserService(UserDAO userDao) {
        this.userDao = userDao;
    }
    public User registerUser(Register register) throws UserAlreadyExistsException {
        if (userDao.findByEmailIgnoreCase(register.getEmail()).isPresent()
                || userDao.findByUsernameIgnoreCase(register.getUsername()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        User user = new User();
        user.setEmail(register.getEmail());
        user.setUsername(register.getUsername());
        user.setPassword(register.getPassword());
        user.setPhoneNumber(register.getPhoneNumber());
        user.setRole(register.getRole());
        //todo: encrypt password
        user.setPassword(register.getPassword());
        return userDao.save(user);
    }
}
