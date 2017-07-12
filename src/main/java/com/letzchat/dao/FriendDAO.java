package com.letzchat.dao;

import java.util.List;

import com.letzchat.model.Friend;

public interface FriendDAO {

	public boolean save(Friend friend);
	public boolean update(Friend friend);
	public boolean delete(String id);
	public void delete(String userID, String friendID);
	
	public List<Friend> getAllFriends(String userID);	
	public Friend get(String friendID, String userID);
	
	public Friend getFriendById(String id);
	
	public List<Friend> getSentRequests(String userID);
	public List<Friend> getAllRequests(String userID);
	

	
}