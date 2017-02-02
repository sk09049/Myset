package com.niit.project2.collaboration.dao;

import java.util.List;

import com.niit.project2.collaboration.model.Friend;

public interface FriendDao {
public boolean save(Friend friend);
public Friend get(String userid,String friendid);
public int getMaxId();
public Friend getsinglerow(int id);
public List<Friend> getFriendRequest(String id);
public Friend accept(String userid,String requesterid);
public List<Friend> getMyRequest(String id);
public List<Friend> getMyFriends(String id);
public Friend rejectRequest(String uid,String fid);
public boolean delete(Friend friend);
}
