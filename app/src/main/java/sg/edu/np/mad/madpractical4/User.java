package sg.edu.np.mad.madpractical4;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    public String name;
    public String description;
    public int id;
    public boolean followed;

    public void setName(String username) {this.name = username;}
    public void setDescription(String description) {this.description = description;}
    public void setId(int id) {this.id = id;}
    public void setFollowed(boolean followed) {this.followed = followed;}

    public String getName() {return name;}
    public String getDescription() {return description;}
    public boolean getFollowed() {return followed;}

    public User(String name, String description, int id, boolean followed) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
    }

    // Parcelable implementation
    protected User(Parcel in) {
        name = in.readString();
        description = in.readString();
        id = in.readInt();
        followed = in.readByte() != 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(id);
        dest.writeByte((byte) (followed ? 1 : 0));
    }
}