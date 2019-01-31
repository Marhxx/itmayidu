package com.spring.api.entity;

import static javax.persistence.GenerationType.IDENTITY;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

/**
 * 会员表管理控制器
 *
 * @author liujiajin
 * @Date 2018-08-17 02:11:11
 */
@Entity
@Table(name = "tb_member_info")
public class TbMemberInfo implements java.io.Serializable {
	
	// Fields
	
	//序列号
	private Long tmiId;
	//登录账户
	private String tmiLoginUser;
	//登录密码
	private String tmiLoginPass;
	//支付密码
	private String tmiPayPassword;
	//支付密码输入错误次数
	private Integer tmiPayPasswordWrong;
	//昵称 (昵称，默认为手机号如188**2828)
	private String tmiNickName;
	//手机号码
	private String tmiPhone;
	//性别 1:男 0:女
	private String tmiSex;
	//职业
	private String tmiTrade;
	//所属省
	private Long tmiProvId;
	//所属市
	private Long tmiCityId;
	//所属区
	private Long tmiRegionId;
	//详细地址
	private String tmiAddress;
	//账户等级 1:普通会员2:创业会员3:梦想会员4:明星会员
	private Long tmiLevel;
	//主播等级
	private Long tmiShowLevel;
	//魅力值
	private Integer tmiCharmValue;
	//个性签名
	private String tmiDesp;
	//关注数
	private Integer tmiFollowCount;
	//身份证认证 1:已认证 0:未认证
	private String tmiSfzCheck;
	//身份证号
	private String tmiSfz;
	//银行卡认证 1:已认证 0:未认证
	private String tmiYhcCheck;
	//银行卡号
	private String tmiBankCard;
	//大V认证 1:已认证 0:未认证
	private String tmiVCheck;
	//龙豆
	private Integer tmiLongdou;
	//龙币
	private Integer tmiLongbi;
	//邀请码
	private String tmiInviteCode;
	//二维码
	private String tmiQrCode;
	//推荐人id
	private Long tmiParentId;
	//头像
	private String tmiIcon;
	//生日
	private String tmiBirthday;
	//qq标识
	private String tmiQqId;
	//微信标识
	private String tmiWechatId;
	//微博标识
	private String tmiMicrpblogidId;
	//状态 1正常 0删除 2冻结
	private Integer tmiStatus;
	//注册时间
	private Timestamp tmiAddDate;
	//姓名
	private String tmiName;
	//余额
	private Double tmiAmount;
	//票务订单
	private Long tmiTicketNumber;
	//商品订单
	private Long tmiProductNumber;
	//票务和商品订单总额
	private Double tmiMoney;
	//票务和商品订单总额
	private Long tmiLongdouNum;
	//票务和商品订单总额
	private Long tmiLongbiNum;
	//累计获取总金额
	private Double tmiMoneyGet;
	//累计获取总额
	private Long tmiLongdouGet;
	//累计获取总额
	private Long tmiLongbiGet;
	//累计支出总金额
	private Double tmiMoneyOut;
	//累计支出总额
	private Long tmiLongdouOut;
	//累计支出总额
	private Long tmiLongbiOut;
	
	// Constructors

	/** default constructor */
	public TbMemberInfo() {
	}
	
	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tmi_id", unique = true, nullable = false, length=19)
	public Long getTmiId() {
		return this.tmiId;
	}
	
	public void setTmiId(Long tmiId) {
		this.tmiId = tmiId;
	}
	
	@Column(name = "tmi_login_user",  nullable = false, length=30)
	public String getTmiLoginUser() {
		return this.tmiLoginUser;
	}
	
	public void setTmiLoginUser(String tmiLoginUser) {
		this.tmiLoginUser = tmiLoginUser;
	}
	
	@Column(name = "tmi_login_pass",  nullable = false, length=50)
	public String getTmiLoginPass() {
		return this.tmiLoginPass;
	}
	
	public void setTmiLoginPass(String tmiLoginPass) {
		this.tmiLoginPass = tmiLoginPass;
	}
	
	@Column(name = "tmi_pay_password",  nullable = false, length=50)
	public String getTmiPayPassword() {
		return this.tmiPayPassword;
	}
	
	public void setTmiPayPassword(String tmiPayPassword) {
		this.tmiPayPassword = tmiPayPassword;
	}
	
	@Column(name = "tmi_pay_password_wrong",  nullable = false, length=10)
	public Integer getTmiPayPasswordWrong() {
		return this.tmiPayPasswordWrong;
	}
	
	public void setTmiPayPasswordWrong(Integer tmiPayPasswordWrong) {
		this.tmiPayPasswordWrong = tmiPayPasswordWrong;
	}
	
	@Column(name = "tmi_nick_name",  nullable = false, length=20)
	public String getTmiNickName() {
		return this.tmiNickName;
	}
	
	public void setTmiNickName(String tmiNickName) {
		this.tmiNickName = tmiNickName;
	}
	
	@Column(name = "tmi_phone",  nullable = false, length=21)
	public String getTmiPhone() {
		return this.tmiPhone;
	}
	
	public void setTmiPhone(String tmiPhone) {
		this.tmiPhone = tmiPhone;
	}
	
	@Column(name = "tmi_sex",  nullable = false, length=0)
	public String getTmiSex() {
		return this.tmiSex;
	}
	
	public void setTmiSex(String tmiSex) {
		this.tmiSex = tmiSex;
	}
	
	@Column(name = "tmi_trade",  nullable = false, length=50)
	public String getTmiTrade() {
		return this.tmiTrade;
	}
	
	public void setTmiTrade(String tmiTrade) {
		this.tmiTrade = tmiTrade;
	}
	
	@Column(name = "tmi_prov_id",  nullable = false, length=19)
	public Long getTmiProvId() {
		return this.tmiProvId;
	}
	
	public void setTmiProvId(Long tmiProvId) {
		this.tmiProvId = tmiProvId;
	}
	
	@Column(name = "tmi_city_id",  nullable = false, length=19)
	public Long getTmiCityId() {
		return this.tmiCityId;
	}
	
	public void setTmiCityId(Long tmiCityId) {
		this.tmiCityId = tmiCityId;
	}
	
	@Column(name = "tmi_region_id",  nullable = false, length=19)
	public Long getTmiRegionId() {
		return this.tmiRegionId;
	}
	
	public void setTmiRegionId(Long tmiRegionId) {
		this.tmiRegionId = tmiRegionId;
	}
	
	@Column(name = "tmi_address",  nullable = false, length=256)
	public String getTmiAddress() {
		return this.tmiAddress;
	}
	
	public void setTmiAddress(String tmiAddress) {
		this.tmiAddress = tmiAddress;
	}
	
	@Column(name = "tmi_level",  nullable = false, length=19)
	public Long getTmiLevel() {
		return this.tmiLevel;
	}
	
	public void setTmiLevel(Long tmiLevel) {
		this.tmiLevel = tmiLevel;
	}
	
	@Column(name = "tmi_show_level",  nullable = false, length=19)
	public Long getTmiShowLevel() {
		return this.tmiShowLevel;
	}
	
	public void setTmiShowLevel(Long tmiShowLevel) {
		this.tmiShowLevel = tmiShowLevel;
	}
	
	@Column(name = "tmi_charm_value",  nullable = false, length=10)
	public Integer getTmiCharmValue() {
		return this.tmiCharmValue;
	}
	
	public void setTmiCharmValue(Integer tmiCharmValue) {
		this.tmiCharmValue = tmiCharmValue;
	}
	
	@Column(name = "tmi_desp",  nullable = false, length=256)
	public String getTmiDesp() {
		return this.tmiDesp;
	}
	
	public void setTmiDesp(String tmiDesp) {
		this.tmiDesp = tmiDesp;
	}
	
	@Column(name = "tmi_follow_count",  nullable = false, length=10)
	public Integer getTmiFollowCount() {
		return this.tmiFollowCount;
	}
	
	public void setTmiFollowCount(Integer tmiFollowCount) {
		this.tmiFollowCount = tmiFollowCount;
	}
	
	@Column(name = "tmi_sfz_check",  nullable = false, length=0)
	public String getTmiSfzCheck() {
		return this.tmiSfzCheck;
	}
	
	public void setTmiSfzCheck(String tmiSfzCheck) {
		this.tmiSfzCheck = tmiSfzCheck;
	}
	
	@Column(name = "tmi_sfz",  nullable = false, length=18)
	public String getTmiSfz() {
		return this.tmiSfz;
	}
	
	public void setTmiSfz(String tmiSfz) {
		this.tmiSfz = tmiSfz;
	}
	
	@Column(name = "tmi_yhc_check",  nullable = false, length=0)
	public String getTmiYhcCheck() {
		return this.tmiYhcCheck;
	}
	
	public void setTmiYhcCheck(String tmiYhcCheck) {
		this.tmiYhcCheck = tmiYhcCheck;
	}
	
	@Column(name = "tmi_bank_card",  nullable = false, length=20)
	public String getTmiBankCard() {
		return this.tmiBankCard;
	}
	
	public void setTmiBankCard(String tmiBankCard) {
		this.tmiBankCard = tmiBankCard;
	}
	
	@Column(name = "tmi_v_check",  nullable = false, length=0)
	public String getTmiVCheck() {
		return this.tmiVCheck;
	}
	
	public void setTmiVCheck(String tmiVCheck) {
		this.tmiVCheck = tmiVCheck;
	}
	
	@Column(name = "tmi_longdou",  nullable = false, length=10)
	public Integer getTmiLongdou() {
		return this.tmiLongdou;
	}
	
	public void setTmiLongdou(Integer tmiLongdou) {
		this.tmiLongdou = tmiLongdou;
	}
	
	@Column(name = "tmi_longbi",  nullable = false, length=10)
	public Integer getTmiLongbi() {
		return this.tmiLongbi;
	}
	
	public void setTmiLongbi(Integer tmiLongbi) {
		this.tmiLongbi = tmiLongbi;
	}
	
	@Column(name = "tmi_invite_code",  nullable = false, length=20)
	public String getTmiInviteCode() {
		return this.tmiInviteCode;
	}
	
	public void setTmiInviteCode(String tmiInviteCode) {
		this.tmiInviteCode = tmiInviteCode;
	}
	
	@Column(name = "tmi_qr_code",  nullable = false, length=128)
	public String getTmiQrCode() {
		return this.tmiQrCode;
	}
	
	public void setTmiQrCode(String tmiQrCode) {
		this.tmiQrCode = tmiQrCode;
	}
	
	@Column(name = "tmi_parent_id",  nullable = false, length=19)
	public Long getTmiParentId() {
		return this.tmiParentId;
	}
	
	public void setTmiParentId(Long tmiParentId) {
		this.tmiParentId = tmiParentId;
	}
	
	@Column(name = "tmi_icon",  nullable = false, length=128)
	public String getTmiIcon() {
		return this.tmiIcon;
	}
	
	public void setTmiIcon(String tmiIcon) {
		this.tmiIcon = tmiIcon;
	}
	
	@Column(name = "tmi_birthday",  nullable = false, length=10)
	public String getTmiBirthday() {
		return this.tmiBirthday;
	}
	
	public void setTmiBirthday(String tmiBirthday) {
		this.tmiBirthday = tmiBirthday;
	}
	
	@Column(name = "tmi_qq_id",  nullable = false, length=50)
	public String getTmiQqId() {
		return this.tmiQqId;
	}
	
	public void setTmiQqId(String tmiQqId) {
		this.tmiQqId = tmiQqId;
	}
	
	@Column(name = "tmi_wechat_id",  nullable = false, length=50)
	public String getTmiWechatId() {
		return this.tmiWechatId;
	}
	
	public void setTmiWechatId(String tmiWechatId) {
		this.tmiWechatId = tmiWechatId;
	}
	
	@Column(name = "tmi_micrpblogId_id",  nullable = false, length=50)
	public String getTmiMicrpblogidId() {
		return this.tmiMicrpblogidId;
	}
	
	public void setTmiMicrpblogidId(String tmiMicrpblogidId) {
		this.tmiMicrpblogidId = tmiMicrpblogidId;
	}
	
	@Column(name = "tmi_status",  nullable = false, length=10)
	public Integer getTmiStatus() {
		return this.tmiStatus;
	}
	
	public void setTmiStatus(Integer tmiStatus) {
		this.tmiStatus = tmiStatus;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Column(name = "tmi_add_date",  nullable = false, length=19)
	public Timestamp getTmiAddDate() {
		return this.tmiAddDate;
	}
	
	public void setTmiAddDate(Timestamp tmiAddDate) {
		this.tmiAddDate = tmiAddDate;
	}
	
	@Column(name = "tmi_name",  nullable = false, length=20)
	public String getTmiName() {
		return this.tmiName;
	}
	
	public void setTmiName(String tmiName) {
		this.tmiName = tmiName;
	}
	
	@Column(name = "tmi_amount",  nullable = false, length=20)
	public Double getTmiAmount() {
		return this.tmiAmount;
	}
	
	public void setTmiAmount(Double tmiAmount) {
		this.tmiAmount = tmiAmount;
	}
	
	@Column(name = "tmi_ticket_number",  nullable = false, length=19)
	public Long getTmiTicketNumber() {
		return this.tmiTicketNumber;
	}
	
	public void setTmiTicketNumber(Long tmiTicketNumber) {
		this.tmiTicketNumber = tmiTicketNumber;
	}
	
	@Column(name = "tmi_product_number",  nullable = false, length=19)
	public Long getTmiProductNumber() {
		return this.tmiProductNumber;
	}
	
	public void setTmiProductNumber(Long tmiProductNumber) {
		this.tmiProductNumber = tmiProductNumber;
	}
	
	@Column(name = "tmi_money",  nullable = false, length=20)
	public Double getTmiMoney() {
		return this.tmiMoney;
	}
	
	public void setTmiMoney(Double tmiMoney) {
		this.tmiMoney = tmiMoney;
	}
	
	@Column(name = "tmi_longdou_num",  nullable = false, length=19)
	public Long getTmiLongdouNum() {
		return this.tmiLongdouNum;
	}
	
	public void setTmiLongdouNum(Long tmiLongdouNum) {
		this.tmiLongdouNum = tmiLongdouNum;
	}
	
	@Column(name = "tmi_longbi_num",  nullable = false, length=19)
	public Long getTmiLongbiNum() {
		return this.tmiLongbiNum;
	}
	
	public void setTmiLongbiNum(Long tmiLongbiNum) {
		this.tmiLongbiNum = tmiLongbiNum;
	}
	
	@Column(name = "tmi_money_get",  nullable = false, length=20)
	public Double getTmiMoneyGet() {
		return this.tmiMoneyGet;
	}
	
	public void setTmiMoneyGet(Double tmiMoneyGet) {
		this.tmiMoneyGet = tmiMoneyGet;
	}
	
	@Column(name = "tmi_longdou_get",  nullable = false, length=19)
	public Long getTmiLongdouGet() {
		return this.tmiLongdouGet;
	}
	
	public void setTmiLongdouGet(Long tmiLongdouGet) {
		this.tmiLongdouGet = tmiLongdouGet;
	}
	
	@Column(name = "tmi_longbi_get",  nullable = false, length=19)
	public Long getTmiLongbiGet() {
		return this.tmiLongbiGet;
	}
	
	public void setTmiLongbiGet(Long tmiLongbiGet) {
		this.tmiLongbiGet = tmiLongbiGet;
	}
	
	@Column(name = "tmi_money_out",  nullable = false, length=20)
	public Double getTmiMoneyOut() {
		return this.tmiMoneyOut;
	}
	
	public void setTmiMoneyOut(Double tmiMoneyOut) {
		this.tmiMoneyOut = tmiMoneyOut;
	}
	
	@Column(name = "tmi_longdou_out",  nullable = false, length=19)
	public Long getTmiLongdouOut() {
		return this.tmiLongdouOut;
	}
	
	public void setTmiLongdouOut(Long tmiLongdouOut) {
		this.tmiLongdouOut = tmiLongdouOut;
	}
	
	@Column(name = "tmi_longbi_out",  nullable = false, length=19)
	public Long getTmiLongbiOut() {
		return this.tmiLongbiOut;
	}
	
	public void setTmiLongbiOut(Long tmiLongbiOut) {
		this.tmiLongbiOut = tmiLongbiOut;
	}
	
	
}