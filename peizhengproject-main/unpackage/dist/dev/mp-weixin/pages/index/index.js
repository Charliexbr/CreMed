"use strict";
const common_vendor = require("../../common/vendor.js");
const common_assets = require("../../common/assets.js");
if (!Array) {
  const _easycom_NavBar2 = common_vendor.resolveComponent("NavBar");
  _easycom_NavBar2();
}
const _easycom_NavBar = () => "../../components/NavBar/NavBar.js";
if (!Math) {
  _easycom_NavBar();
}
const _sfc_main = {
  __name: "index",
  setup(__props) {
    const app = getApp();
    const bannerList = common_vendor.ref([]);
    const nav2s = common_vendor.ref([]);
    const navs = common_vendor.ref([]);
    const hospitalList = common_vendor.ref([]);
    common_vendor.onLoad(() => {
      app.globalData.utils.getUserInfo();
      app.globalData.utils.request2({
        url: "/Index/index",
        data: {
          aid: 1
          // 假设 aid 是固定值或可以从其他地方获取
        },
        success: (res) => {
          console.log("请求成功，响应数据:", res);
          if (res && res.data && res.data.data) {
            bannerList.value = res.data.data.slides;
            nav2s.value = res.data.data.nav2s;
            navs.value = res.data.data.navs;
            hospitalList.value = res.data.data.hospitals;
            console.log(bannerList.value, "res");
          } else {
            console.error("响应数据格式不正确:", res);
          }
        },
        fail: (error) => {
          console.error("请求失败:", error);
        }
      });
    });
    const goPage = (url) => {
      common_vendor.index.navigateTo({
        url
      });
    };
    const goHospitalDetail = (id) => {
      common_vendor.index.navigateTo({
        url: "/pages/hospital/index?svid=1&hid=" + id
      });
    };
    return (_ctx, _cache) => {
      return common_vendor.e({
        a: common_vendor.p({
          isHome: true
        }),
        b: common_assets._imports_0,
        c: common_assets._imports_0$1,
        d: bannerList.value && bannerList.value.length > 0
      }, bannerList.value && bannerList.value.length > 0 ? {
        e: common_vendor.f(bannerList.value, (item, index, i0) => {
          return {
            a: item.pic_image_url,
            b: item.id
          };
        })
      } : {}, {
        f: nav2s.value && nav2s.value.length > 0
      }, nav2s.value && nav2s.value.length > 0 ? {
        g: common_vendor.f(nav2s.value, (item, index, i0) => {
          return {
            a: item.pic_image_url,
            b: common_vendor.o(($event) => goPage(item.stype_link), item.id),
            c: item.id
          };
        })
      } : {}, {
        h: common_vendor.f(navs.value, (item, index, i0) => {
          return {
            a: item.pic_image_url,
            b: common_vendor.t(item.title),
            c: common_vendor.s("color:" + item.tcolor ? item.tcolor : ""),
            d: common_vendor.o(($event) => goPage(item.stype_link), item.id),
            e: item.id
          };
        }),
        i: common_vendor.f(hospitalList.value, (item, index, i0) => {
          return {
            a: item.avatar ? item.avatar_url : "../../static/resource/images/avatar.jpg",
            b: common_vendor.t(item.name),
            c: common_vendor.t(item.rank),
            d: common_vendor.t(item.label),
            e: common_vendor.t(item.intro),
            f: item.id,
            g: common_vendor.o(($event) => goHospitalDetail(item.id), item.id)
          };
        })
      });
    };
  }
};
wx.createPage(_sfc_main);
