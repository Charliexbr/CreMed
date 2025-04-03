"use strict";
const common_vendor = require("../../common/vendor.js");
const _sfc_main = {
  data() {
    return {
      inputMessage: "",
      // 用户输入的消息
      messages: [],
      // 消息列表
      userAvatar: "../../static/my_avatar.jpg",
      // 用户头像路径
      aiAvatar: "../../static/robot_square.png"
      // AI 头像路径
    };
  },
  methods: {
    // 调用 AI 接口
    async callAI(message) {
      const url = "https://api.siliconflow.cn/v1/chat/completions";
      const options = {
        method: "POST",
        header: {
          Authorization: "Bearer sk-roukuuwtzptzrwomfgaldlbsvgogfpuvumyetqzlcvjudgmc",
          // 替换为你的实际 API 密钥
          "Content-Type": "application/json"
        },
        data: {
          messages: [
            { role: "user", content: message }
          ],
          model: "ft:LoRA/Qwen/Qwen2.5-7B-Instruct:cm3cthfxn01ev11v5fqml9ac6:peizhen9:dnqusutmjisamusyhlsg"
        }
      };
      try {
        const result = await new Promise((resolve, reject) => {
          common_vendor.index.request({
            url,
            // 确保 URL 正确传递
            ...options,
            success: (res) => resolve(res),
            fail: (err) => reject(err)
          });
        });
        if (result.statusCode === 200 && result.data) {
          const { choices } = result.data;
          if (choices && choices.length > 0) {
            return choices[0].message.content;
          } else {
            throw new Error("API 返回数据格式异常");
          }
        } else {
          throw new Error("请求失败，状态码：" + result.statusCode);
        }
      } catch (error) {
        console.error("调用 AI 接口失败", error);
        return "AI 接口请求失败，请稍后重试。";
      }
    },
    // 发送消息
    async sendMessage() {
      if (this.inputMessage.trim() === "")
        return;
      this.messages.push({ isSender: true, content: this.inputMessage });
      try {
        const aiReply = await this.callAI(this.inputMessage);
        this.messages.push({ isSender: false, content: aiReply });
      } catch (error) {
        this.messages.push({
          isSender: false,
          content: "AI 回复失败，请稍后再试。"
        });
      }
      this.inputMessage = "";
    }
  }
};
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: common_vendor.f($data.messages, (msg, index, i0) => {
      return {
        a: msg.isSender ? $data.userAvatar : $data.aiAvatar,
        b: common_vendor.t(msg.content),
        c: index,
        d: common_vendor.n(msg.isSender ? "message-sender" : "message-receiver")
      };
    }),
    b: $data.inputMessage,
    c: common_vendor.o(($event) => $data.inputMessage = $event.detail.value),
    d: common_vendor.o((...args) => $options.sendMessage && $options.sendMessage(...args))
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render], ["__scopeId", "data-v-5a559478"]]);
wx.createPage(MiniProgramPage);
