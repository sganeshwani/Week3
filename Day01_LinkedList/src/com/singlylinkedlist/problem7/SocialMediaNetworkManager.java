package com.singlylinkedlist.problem7;

// Class representing a friend node in the singly linked list
class FriendNode {
    int friendID;
    FriendNode next;

    public FriendNode(int friendID, FriendNode friendList) {
        this.friendID = friendID;
        this.next = null;
    }
}

// Class representing a user in the social media system
class UserNode {
    int userID;
    String name;
    int age;
    FriendNode friendList;
    UserNode next;

    public UserNode(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendList = null;
        this.next = null;
    }
}

// Class to manage social media friend connections using a singly linked list
class SocialMediaNetwork {
    private UserNode head;

    public SocialMediaNetwork() {
        this.head = null;
    }

    // Add a new user to the network
    public void addUser(int userID, String name, int age) {
        UserNode newUser = new UserNode(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    // Find user by ID
    private UserNode findUser(int userID) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userID == userID) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriend(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);
        if (user1 != null && user2 != null) {
            user1.friendList = new FriendNode(userID2, user1.friendList);
            user2.friendList = new FriendNode(userID1, user2.friendList);
        }
    }

    // Remove a friend connection
    public void removeFriend(int userID1, int userID2) {
        removeFriendHelper(userID1, userID2);
        removeFriendHelper(userID2, userID1);
    }

    private void removeFriendHelper(int userID, int friendID) {
        UserNode user = findUser(userID);
        if (user == null || user.friendList == null) return;

        FriendNode temp = user.friendList, prev = null;
        while (temp != null && temp.friendID != friendID) {
            prev = temp;
            temp = temp.next;
        }
        if (temp != null) {
            if (prev == null) user.friendList = temp.next;
            else prev.next = temp.next;
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userID) {
        UserNode user = findUser(userID);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.print("Friends of " + user.name + " (ID: " + user.userID + "): ");
        FriendNode temp = user.friendList;
        while (temp != null) {
            System.out.print(temp.friendID + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        System.out.print("Mutual friends: ");
        FriendNode temp1 = user1.friendList;
        while (temp1 != null) {
            FriendNode temp2 = user2.friendList;
            while (temp2 != null) {
                if (temp1.friendID == temp2.friendID) {
                    System.out.print(temp1.friendID + " ");
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        System.out.println();
    }

    // Count the number of friends for each user
    public void countFriends(int userID) {
        UserNode user = findUser(userID);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        int count = 0;
        FriendNode temp = user.friendList;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println(user.name + " has " + count + " friends.");
    }
}

// Separate class for main method
class SocialMediaNetworkManager {
    public static void main(String[] args) {
        SocialMediaNetwork network = new SocialMediaNetwork();

        network.addUser(1, "Alice", 21);
        network.addUser(2, "Bob", 18);
        network.addUser(3, "Charlie", 22);

        network.addFriend(1, 2);
        network.addFriend(1, 3);

        network.displayFriends(1);
        network.displayFriends(2);

        network.findMutualFriends(1, 2);
        network.countFriends(1);

        network.removeFriend(1, 2);
        network.displayFriends(1);
    }
}
