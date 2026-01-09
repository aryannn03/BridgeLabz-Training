import java.util.Scanner;

class FriendNode{
    int friendId;
    FriendNode next;

    FriendNode(int friendId){
        this.friendId=friendId;
        this.next=null;
    }
}

class User{
    int id;
    String name;
    int age;
    FriendNode friends;
    User next;

    User(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
        this.friends=null;
        this.next=null;
    }
}

class SocialMediaList{
    private User head;

    void addUser(int id,String name,int age){
        User newUser=new User(id,name,age);
        newUser.next=head;
        head=newUser;
    }

    User findUserById(int id){
        User temp=head;
        while(temp!=null){
            if(temp.id==id){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }

    void searchByName(String name){
        User temp=head;
        boolean found=false;
        while(temp!=null){
            if(temp.name.equals(name)){
                System.out.println("Id:"+temp.id+",Name:"+temp.name+",Age:"+temp.age);
                found=true;
            }
            temp=temp.next;
        }
        if(!found){
            System.out.println("User not found");
        }
    }

    void addFriend(int id1,int id2){
        User u1=findUserById(id1);
        User u2=findUserById(id2);
        if(u1==null||u2==null){
            System.out.println("User not found");
            return;
        }
        addFriendNode(u1,id2);
        addFriendNode(u2,id1);
        System.out.println("Friend connection added");
    }

    void addFriendNode(User user,int friendId){
        FriendNode newNode=new FriendNode(friendId);
        newNode.next=user.friends;
        user.friends=newNode;
    }

    void removeFriend(int id1,int id2){
        User u1=findUserById(id1);
        User u2=findUserById(id2);
        if(u1==null||u2==null){
            System.out.println("User not found");
            return;
        }
        removeFriendNode(u1,id2);
        removeFriendNode(u2,id1);
        System.out.println("Friend connection removed");
    }

    void removeFriendNode(User user,int friendId){
        FriendNode temp=user.friends;
        if(temp==null){
            return;
        }
        if(temp.friendId==friendId){
            user.friends=temp.next;
            return;
        }
        while(temp.next!=null&&temp.next.friendId!=friendId){
            temp=temp.next;
        }
        if(temp.next!=null){
            temp.next=temp.next.next;
        }
    }

    void displayFriends(int id){
        User user=findUserById(id);
        if(user==null){
            System.out.println("User not found");
            return;
        }
        FriendNode temp=user.friends;
        if(temp==null){
            System.out.println("No friends");
            return;
        }
        while(temp!=null){
            System.out.println("FriendId:"+temp.friendId);
            temp=temp.next;
        }
    }

    void mutualFriends(int id1,int id2){
        User u1=findUserById(id1);
        User u2=findUserById(id2);
        if(u1==null||u2==null){
            System.out.println("User not found");
            return;
        }
        FriendNode f1=u1.friends;
        boolean found=false;
        while(f1!=null){
            FriendNode f2=u2.friends;
            while(f2!=null){
                if(f1.friendId==f2.friendId){
                    System.out.println("MutualFriendId:"+f1.friendId);
                    found=true;
                }
                f2=f2.next;
            }
            f1=f1.next;
        }
        if(!found){
            System.out.println("No mutual friends");
        }
    }

    void countFriends(){
        User temp=head;
        while(temp!=null){
            int count=0;
            FriendNode f=temp.friends;
            while(f!=null){
                count++;
                f=f.next;
            }
            System.out.println("UserId:"+temp.id+",Friends:"+count);
            temp=temp.next;
        }
    }

    void searchById(int id){
        User user=findUserById(id);
        if(user==null){
            System.out.println("User not found");
            return;
        }
        System.out.println("Id:"+user.id+",Name:"+user.name+",Age:"+user.age);
    }
}

public class SocialMediaFriends{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        SocialMediaList list=new SocialMediaList();

        while(true){
            System.out.println("1AddUser 2AddFriend 3RemoveFriend 4Mutual 5DisplayFriends 6SearchId 7SearchName 8CountFriends 9Exit");
            int choice=sc.nextInt();

            switch(choice){
                case 1:
                    list.addUser(sc.nextInt(),sc.next(),sc.nextInt());
                    break;
                case 2:
                    list.addFriend(sc.nextInt(),sc.nextInt());
                    break;
                case 3:
                    list.removeFriend(sc.nextInt(),sc.nextInt());
                    break;
                case 4:
                    list.mutualFriends(sc.nextInt(),sc.nextInt());
                    break;
                case 5:
                    list.displayFriends(sc.nextInt());
                    break;
                case 6:
                    list.searchById(sc.nextInt());
                    break;
                case 7:
                    list.searchByName(sc.next());
                    break;
                case 8:
                    list.countFriends();
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
