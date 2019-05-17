package com.hearatale.sightword.data.model.phonics;

import android.os.Parcel;

import com.hearatale.sightword.data.model.base.BaseModel;

public class SightWordModel extends BaseModel {
    private String text = "";
    private int starCount = 0;
    private SentenceModel firstSentence = new SentenceModel();
    private SentenceModel secondSentence = new SentenceModel();
    private String focus_item_id = "";

    public SightWordModel() {
    }

    public SightWordModel(String text, SentenceModel firstSentence, SentenceModel secondSentence,
                          String focus_item_id) {
        this.text = text;
        this.firstSentence = firstSentence;
        this.secondSentence = secondSentence;
        this.focus_item_id = focus_item_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SentenceModel getFirstSentence() {
        return firstSentence;
    }

    public void setFirstSentence(SentenceModel firstSentence) {
        this.firstSentence = firstSentence;
    }

    public SentenceModel getSecondSentence() {
        return secondSentence;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public void setSecondSentence(SentenceModel secondSentence) {
        this.secondSentence = secondSentence;
    }

    public String getFocusItemID() { return focus_item_id; }

    public void setFocusItemID(String focus_item_id) { this.focus_item_id = focus_item_id; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.text);
        dest.writeInt(this.starCount);
        dest.writeParcelable(this.firstSentence, flags);
        dest.writeParcelable(this.secondSentence, flags);
        dest.writeString(this.focus_item_id);
    }

    protected SightWordModel(Parcel in) {
        this.text = in.readString();
        this.starCount = in.readInt();
        this.firstSentence = in.readParcelable(SentenceModel.class.getClassLoader());
        this.secondSentence = in.readParcelable(SentenceModel.class.getClassLoader());
        this.focus_item_id = in.readString();
    }

    public static final Creator<SightWordModel> CREATOR = new Creator<SightWordModel>() {
        @Override
        public SightWordModel createFromParcel(Parcel source) {
            return new SightWordModel(source);
        }

        @Override
        public SightWordModel[] newArray(int size) {
            return new SightWordModel[size];
        }
    };
}
