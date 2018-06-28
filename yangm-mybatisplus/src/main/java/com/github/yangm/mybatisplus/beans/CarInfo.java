package com.github.yangm.mybatisplus.beans;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangm
 * @since 2018-06-28
 */
public class CarInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String openId;
    /**
     * 车牌
     */
    private String carPlate;
    /**
     * 品牌
     */
    private String carBrand;
    /**
     * 车架号
     */
    private String frameNum;
    /**
     * 车辆类型
     */
    private String carType;
    /**
     * 发动机号
     */
    private String engineNum;
    /**
     * 车座
     */
    private String carSeat;
    /**
     * 注册日期
     */
    private Date registerDay;
    /**
     * 车主
     */
    private String carOwner;
    /**
     * 身份证号
     */
    private String carOwnerIdentity;
    /**
     * 是否默认 1是
     */
    private Integer marker;
    private Date createTime;
    /**
     * 是否删除 0是 1否
     */
    private Integer del;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getFrameNum() {
        return frameNum;
    }

    public void setFrameNum(String frameNum) {
        this.frameNum = frameNum;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getEngineNum() {
        return engineNum;
    }

    public void setEngineNum(String engineNum) {
        this.engineNum = engineNum;
    }

    public String getCarSeat() {
        return carSeat;
    }

    public void setCarSeat(String carSeat) {
        this.carSeat = carSeat;
    }

    public Date getRegisterDay() {
        return registerDay;
    }

    public void setRegisterDay(Date registerDay) {
        this.registerDay = registerDay;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    public String getCarOwnerIdentity() {
        return carOwnerIdentity;
    }

    public void setCarOwnerIdentity(String carOwnerIdentity) {
        this.carOwnerIdentity = carOwnerIdentity;
    }

    public Integer getMarker() {
        return marker;
    }

    public void setMarker(Integer marker) {
        this.marker = marker;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "CarInfo{" +
        ", id=" + id +
        ", openId=" + openId +
        ", carPlate=" + carPlate +
        ", carBrand=" + carBrand +
        ", frameNum=" + frameNum +
        ", carType=" + carType +
        ", engineNum=" + engineNum +
        ", carSeat=" + carSeat +
        ", registerDay=" + registerDay +
        ", carOwner=" + carOwner +
        ", carOwnerIdentity=" + carOwnerIdentity +
        ", marker=" + marker +
        ", createTime=" + createTime +
        ", del=" + del +
        "}";
    }
}
