package fyi.rxretrofittest.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiDetail implements Parcelable {

    @SerializedName("dstOffset")
    @Expose
    private Integer dstOffset;
    @SerializedName("rawOffset")
    @Expose
    private Integer rawOffset;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("timeZoneId")
    @Expose
    private String timeZoneId;
    @SerializedName("timeZoneName")
    @Expose
    private String timeZoneName;

    public Integer getDstOffset() {
        return dstOffset;
    }

    public void setDstOffset(Integer dstOffset) {
        this.dstOffset = dstOffset;
    }

    public Integer getRawOffset() {
        return rawOffset;
    }

    public void setRawOffset(Integer rawOffset) {
        this.rawOffset = rawOffset;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public String getTimeZoneName() {
        return timeZoneName;
    }

    public void setTimeZoneName(String timeZoneName) {
        this.timeZoneName = timeZoneName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.dstOffset);
        dest.writeValue(this.rawOffset);
        dest.writeString(this.status);
        dest.writeString(this.timeZoneId);
        dest.writeString(this.timeZoneName);
    }

    public ApiDetail() {
    }

    protected ApiDetail(Parcel in) {
        this.dstOffset = (Integer) in.readValue(Integer.class.getClassLoader());
        this.rawOffset = (Integer) in.readValue(Integer.class.getClassLoader());
        this.status = in.readString();
        this.timeZoneId = in.readString();
        this.timeZoneName = in.readString();
    }

    public static final Parcelable.Creator<ApiDetail> CREATOR = new Parcelable.Creator<ApiDetail>() {
        @Override
        public ApiDetail createFromParcel(Parcel source) {
            return new ApiDetail(source);
        }

        @Override
        public ApiDetail[] newArray(int size) {
            return new ApiDetail[size];
        }
    };

    @Override
    public String toString() {
        return "ApiDetail{" +
                "dstOffset=" + dstOffset +
                ", rawOffset=" + rawOffset +
                ", status='" + status + '\'' +
                ", timeZoneId='" + timeZoneId + '\'' +
                ", timeZoneName='" + timeZoneName + '\'' +
                '}';
    }
}
