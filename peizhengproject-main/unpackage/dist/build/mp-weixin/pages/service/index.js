"use strict";const e=require("../../common/vendor.js");if(!Array){(e.resolveComponent("dtPicker")+e.resolveComponent("uni-popup"))()}Math||((()=>"../../components/dtPicker/dtPicker.js")+(()=>"../../uni_modules/uni-popup/components/uni-popup/uni-popup.js"))();const a={__name:"index",setup(a){const t=getApp(),o=e.ref({}),i=e.ref(0),l=e.ref([]),s=e.reactive({page_xy:"",page_fw:""}),n=e.ref(!1),r=e.reactive({price:"",starttime:0,tel:"",demand:"",address:{userName:"",cityName:"",countyName:"",detailInfo:""},receiveAddress:""}),u=e.ref({name:"",age:"",mobile:"",sex:""}),d=e.ref(null),c=e.ref({validCode:"",phone:""}),v=e.ref({validText:"获取验证码",time:60}),p=e.ref(null);e.onLoad((e=>{m(e)}));const m=a=>{const{svid:s,hid:n}=a;t.globalData.utils.request({url:"/Service/order",data:{svid:s},success:t=>{if(o.value=t.data.data.service,console.log(o.value.stype,"service.value"),l.value=t.data.data.hospitals,a.hid>0){const t=e.toRaw(l.value);for(let e=0;e<t.length;e++){let o=t[e];if(o.id==a.hid){i.value=e,r.price=o.service_price??"";break}}}}})},f=()=>{},h=e=>{const a=parseInt(e.detail.value);i.value=a,r.price=l.value[a].service_price??""},y=e=>{r.starttime=e.detail.value},g=()=>{e.index.navigateTo({url:"/pages/clients/index?act=select"})},x=()=>{e.index.chooseAddress({success:e=>{const{cityName:a,countyName:t,detailInfo:o,userName:i}=e;r.address.userName=i,r.address.cityName=a,r.address.countyName=t,r.address.detailInfo=o},fail:e=>{console.log(e,"err")}})},w=()=>{n.value=!n.value};let T;const _=()=>{if(!n.value)return e.index.showToast({title:"请您阅读并同意<用户协议>和服务协议",duration:1e3,icon:""});const a=e.toRaw(o.value);T=e.toRaw(r);const t=e.toRaw(u.value),s=e.toRaw(l.value);if(a){if(a.stype<100){if(0==i.value)return e.index.showToast({title:"请选择医院",duration:1e3,icon:""});T.hospital_id=s[i.value].id,T.hospital_name=s[i.value].name}if("10"==a.stype||"15"==a.stype||"20"==a.stype){if(0==T.starttime)return e.index.showToast({title:"请选择就诊时间",duration:1e3,icon:""});if(""==t.name)return e.index.showToast({title:"请选择就诊人",duration:1e3,icon:""});if("15"==a.stype&&!T.receiveAddress)return e.index.showToast({title:"请填写接送地址",duration:1e3,icon:""});T.client=t}if("30"==a.stype||"40"==a.stype){if(0==T.starttime)return e.index.showToast({title:"请选择服务时间",duration:1e3,icon:""});if(!T.address.userName)return e.index.showToast({title:"请选择收件信息",duration:1e3,icon:""})}}if(!r.tel)return e.index.showToast({title:"请填写联系电话",duration:1e3,icon:""});T.service_code=a.code,T.service_id=a.id,T.service_name=a.name,T.service_stype=a.stype,console.log(T,"提交订单的数据"),e.index.getStorageSync("token")?S(T):d.value.open("center")};let k=!1;const b=()=>{if(!c.value.phone)return e.index.showToast({title:"请输入手机号",duration:1e3,icon:"none"});if(k)return;k=!0;const a=setInterval((()=>{v.value.time<=0?(v.value.validText="获取验证码",v.value.time=60,clearInterval(a),k=!1):(v.value.time-=1,v.value.validText=`剩余${v.value.time}S`)}),1e3);t.globalData.utils.request({url:"/get/code",method:"POST",data:{tel:c.value.phone},success:a=>{e.index.showToast({title:"验证码发送成功,请尽快验证!",duration:1e3,icon:"none"})},fail:a=>{e.index.showToast({title:a.msg,duration:1e3,icon:"none"})}})},N=()=>{d.value.close()},C=()=>{if(!c.value.phone||!c.value.validCode)return e.index.showToast({title:"请检查输入信息",duration:1e3,icon:"none"});t.globalData.utils.request({url:"/user/authentication",method:"POST",data:{tel:c.value.phone,code:c.value.validCode},success:a=>{e.index.setStorageSync("token",a.data.data.token),d.value.close(),S(T)},fail:a=>{d.value.close(),e.index.showToast({title:a.msg,duration:1e3,icon:"none"})}})},S=a=>{p.value.open("center"),t.globalData.utils.request({url:"/pay/createOrder",method:"POST",header:{token:e.index.getStorageSync("token")},data:a,success:e=>{A(e.wx_code),console.log(e)},fail:e=>{console.log(e)}})},P=()=>{p.value.close(),e.index.switchTab({url:"../order/index"})},A=a=>{var t=new e.UQRCode;t.data=a,t.size=200,t.make();var o=e.index.createCanvasContext("qrcode");t.canvasContext=o,t.drawCanvas()};return e.index.$on("clientData",(e=>{const{age:a,mobile:t,sex:o,name:i}=e;u.value.name=i,u.value.mobile=t,u.value.sex=o,u.value.age=a})),(a,t)=>e.e({a:o.value.icon_image?o.value.icon_image_url:"../../static/resource/images/avatar.jpg",b:e.t(o.value.name),c:e.o(f),d:l.value.length>0&&"10"==o.value.stype||"15"==o.value.stype||"20"==o.value.stype},l.value.length>0&&"10"==o.value.stype||"15"==o.value.stype||"20"==o.value.stype?e.e({e:l.value[i.value].name,f:e.o(h),g:i.value,h:l.value,i:e.o(y),j:e.p({timestamp:r.starttime,placeholder:"请选择就诊时间"}),k:u.value.name,l:e.o(g),m:15==o.value.stype},15==o.value.stype?{n:r.receiveAddress,o:e.o((e=>r.receiveAddress=e.detail.value))}:{},{p:r.tel,q:e.o((e=>r.tel=e.detail.value)),r:r.demand,s:e.o((e=>r.demand=e.detail.value))}):{},{t:l.value.length>0&&"30"==o.value.stype||"40"==o.value.stype},l.value.length>0&&"30"==o.value.stype||"40"==o.value.stype?{v:l.value[i.value].name,w:e.o(h),x:i.value,y:l.value,z:e.o(y),A:e.p({timestamp:r.starttime,placeholder:"请选择期望服务时间"}),B:r.address.userName?r.address.userName+"("+r.address.cityName+r.address.countyName+r.address.detailInfo+")":"",C:e.o(x),D:r.tel,E:e.o((e=>r.tel=e.detail.value)),F:r.demand,G:e.o((e=>r.demand=e.detail.value))}:{},{H:e.n("is_xieyi "+(n.value?"is_xieyi_on":"")),I:e.o(w),J:s.page_xy,K:s.page_fw,L:r.price>0},r.price>0?{M:e.t(r.price)}:{},{N:e.n("btnp "+(n.value?"":"btnp-disabled")),O:e.o(_),P:c.value.phone,Q:e.o((e=>c.value.phone=e.detail.value)),R:c.value.validCode,S:e.o((e=>c.value.validCode=e.detail.value)),T:e.t(v.value.validText),U:e.o(b),V:e.o(N),W:e.o(C),X:e.sr(d,"081b76ea-2",{k:"popup"}),Y:e.p({type:"center","is-mask-click":!1,"background-color":"#fff"}),Z:e.o(P),aa:e.sr(p,"081b76ea-3",{k:"QRCodePopup"}),ab:e.p({type:"center","is-mask-click":!1,"background-color":"#fff"})})}};wx.createPage(a);
