package com.hitherejoe.vineyard.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class Tag implements Comparable<Tag>, Parcelable {
    public long tagId;
    public String tag;
    public long postCount;

    @Override
    public int compareTo(@NonNull Tag another) {
        return (int) (postCount - another.postCount);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.tagId);
        dest.writeString(this.tag);
        dest.writeLong(this.postCount);
    }

    public Tag() {
    }

    protected Tag(Parcel in) {
        this.tagId = in.readLong();
        this.tag = in.readString();
        this.postCount = in.readLong();
    }

    public static final Parcelable.Creator<Tag> CREATOR = new Parcelable.Creator<Tag>() {
        public Tag createFromParcel(Parcel source) {
            return new Tag(source);
        }

        public Tag[] newArray(int size) {
            return new Tag[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag1 = (Tag) o;

        if (tagId != tag1.tagId) return false;
        if (postCount != tag1.postCount) return false;
        return !(tag != null ? !tag.equals(tag1.tag) : tag1.tag != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (tagId ^ (tagId >>> 32));
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (int) (postCount ^ (postCount >>> 32));
        return result;
    }
}
