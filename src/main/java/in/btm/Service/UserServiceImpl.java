package in.btm.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import in.btm.Entity.User;
import in.btm.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

   
}
