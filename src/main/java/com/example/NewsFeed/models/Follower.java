package com.example.NewsFeed.models;

public class Follower extends BaseModel {

    private String followee;
    private String following;

    public String getFollowee() {
        return followee;
    }

    public void setFollowee(String followee) {
        this.followee = followee;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }
}
