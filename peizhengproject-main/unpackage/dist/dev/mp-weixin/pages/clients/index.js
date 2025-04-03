"use strict";
const common_vendor = require("../../common/vendor.js");
const _sfc_main = {
  __name: "index",
  setup(__props) {
    const app = getApp();
    const clients = common_vendor.ref([]);
    const act = common_vendor.ref("");
    common_vendor.onLoad((option) => {
      act.value = option.act;
      const orderId = option.OrderId ? Number(option.OrderId) : null;
      console.log("Received orderId:", orderId);
      console.log("Type of orderId:", typeof orderId);
      if (orderId) {
        app.globalData.orderId = orderId;
      }
      if (option.act == "select") {
        common_vendor.index.setNavigationBarTitle({
          title: "请选择服务对象"
        });
      } else {
        common_vendor.index.setNavigationBarTitle({
          title: "服务人员选择"
        });
      }
      app.globalData.utils.request2({
        url: "/User/clients",
        success: (res) => {
          clients.value = res.data.data.clients;
        }
      });
    });
    const onClientSelected = (item) => {
      const orderId = app.globalData.orderId || null;
      if (!orderId) {
        console.error("Order ID is missing!");
        return;
      }
      const requestData = {
        orderId,
        clientName: item.name
      };
      app.globalData.utils.request2({
        url: "/Order/update",
        // 接口地址
        method: "POST",
        // 使用 POST 方法
        data: requestData,
        // 发送的数据
        success: (res) => {
          console.log("Order updated successfully:", res);
          common_vendor.index.switchTab({
            url: "../order/index"
          });
        },
        fail: (err) => {
          console.error("Failed to update order:", err);
          common_vendor.index.showToast({
            title: "更新订单失败",
            icon: "none"
          });
        }
      });
    };
    return (_ctx, _cache) => {
      return {
        a: common_vendor.f(clients.value, (item, index, i0) => {
          return common_vendor.e({
            a: common_vendor.t(item.name),
            b: common_vendor.t(item.sex == 1 ? "男" : "女"),
            c: common_vendor.n("sext" + item.sex),
            d: common_vendor.t(item.job),
            e: common_vendor.t(item.trait)
          }, act.value == "select" ? {
            f: common_vendor.o(($event) => onClientSelected(item), index)
          } : {
            g: common_vendor.o(($event) => onClientSelected(item), index),
            h: item.id
          }, {
            i: index
          });
        }),
        b: act.value == "select"
      };
    };
  }
};
wx.createPage(_sfc_main);
