package com.peiz.caremed.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Users {
    private int id; // 主键
    private int appId; // 应用ID
    private int areaId; // 区域ID
    private String nickname; // 昵称
    private String avatar; // 头像
    private String mobile; // 手机号
    private String opendd; // OpenID
    private String province; // 省份
    private String city; // 城市
    private String district; // 区县
    private int orders; // 订单数
    private int ordersCancel; // 取消订单数
    private int ordersDone; // 已完成订单数
    private BigDecimal expends; // 支出金额
    private int adminSwitch; // 管理员开关
    private int sellerSwitch; // 卖家开关
    private int blackSwitch; // 黑名单开关
    private Timestamp createtime; // 创建时间
    private Timestamp updatetime; // 更新时间
    private String remark; // 备注
    private int invites; // 邀请数
    private int inviterId; // 邀请人ID
    private BigDecimal sells; // 销售金额
    private BigDecimal sellIncome; // 销售收入
    private BigDecimal sellOutcash; // 销售提现
    private int sellerId; // 卖家ID
    private Timestamp sellerTime; // 卖家时间
    private int myStaffId; // 我的员工ID
    private String avatarUrl; // 头像URL

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOpendd() {
        return opendd;
    }

    public void setOpendd(String opendd) {
        this.opendd = opendd;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getOrdersCancel() {
        return ordersCancel;
    }

    public void setOrdersCancel(int ordersCancel) {
        this.ordersCancel = ordersCancel;
    }

    public int getOrdersDone() {
        return ordersDone;
    }

    public void setOrdersDone(int ordersDone) {
        this.ordersDone = ordersDone;
    }

    public BigDecimal getExpends() {
        return expends;
    }

    public void setExpends(BigDecimal expends) {
        this.expends = expends;
    }

    public int getAdminSwitch() {
        return adminSwitch;
    }

    public void setAdminSwitch(int adminSwitch) {
        this.adminSwitch = adminSwitch;
    }

    public int getSellerSwitch() {
        return sellerSwitch;
    }

    public void setSellerSwitch(int sellerSwitch) {
        this.sellerSwitch = sellerSwitch;
    }

    public int getBlackSwitch() {
        return blackSwitch;
    }

    public void setBlackSwitch(int blackSwitch) {
        this.blackSwitch = blackSwitch;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getInvites() {
        return invites;
    }

    public void setInvites(int invites) {
        this.invites = invites;
    }

    public int getInviterId() {
        return inviterId;
    }

    public void setInviterId(int inviterId) {
        this.inviterId = inviterId;
    }

    public BigDecimal getSells() {
        return sells;
    }

    public void setSells(BigDecimal sells) {
        this.sells = sells;
    }

    public BigDecimal getSellIncome() {
        return sellIncome;
    }

    public void setSellIncome(BigDecimal sellIncome) {
        this.sellIncome = sellIncome;
    }

    public BigDecimal getSellOutcash() {
        return sellOutcash;
    }

    public void setSellOutcash(BigDecimal sellOutcash) {
        this.sellOutcash = sellOutcash;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public Timestamp getSellerTime() {
        return sellerTime;
    }

    public void setSellerTime(Timestamp sellerTime) {
        this.sellerTime = sellerTime;
    }

    public int getMyStaffId() {
        return myStaffId;
    }

    public void setMyStaffId(int myStaffId) {
        this.myStaffId = myStaffId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
