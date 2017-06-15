package com.letzchat.Collaboration.dao;

import java.util.List;

import com.letzchat.Collaboration.model.Friend;

public interface FriendDAO {

	public Friend get(String friendID);
	public List<Friend> list();

	public boolean save(Friend friend);
	public boolean update(Friend friend);
	public boolean delete(String id);
	public void delete(String userID, String friendID);
	
	public List<Friend> getMyFriends(String userID);
	
	public Friend get(String userID, String friendID);
	
	public List<Friend> getNewFriendRequests(String userID);
	public void setOnline(String userID);
	public void setOffLine(String userID);
	public List<Friend> getRequestsSendByMe(String userID);
	

	
}