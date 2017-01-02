package com.scg.persistence;

import com.scg.model.Instructor;
import com.scg.model.User;

import java.util.List;

/**
 * Created by sungbo on 2016-09-14.
 */
public interface PushMapper {

    public List<User> getUserPushList(User user);

    public User getUserPush(User user);

    public List<Instructor> getInsPushList(Instructor instructor);

    public List<User> getAllUser();

}
