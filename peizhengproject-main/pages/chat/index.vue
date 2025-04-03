<template>
  <view class="chat-container">
    <!-- 聊天消息展示区 -->
    <view class="messages">
      <view
        v-for="(msg, index) in messages"
        :key="index"
        :class="['message', msg.isSender ? 'message-sender' : 'message-receiver']"
      >
        <image
          :src="msg.isSender ? userAvatar : aiAvatar"
          class="avatar"
        />
        <view class="bubble">{{ msg.content }}</view>
      </view>
    </view>

    <!-- 输入区 -->
    <view class="input-container">
      <input
        v-model="inputMessage"
        class="input-box"
        placeholder="请输入消息..."
      />
      <button @click="sendMessage" class="send-button">发送</button>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      inputMessage: '', // 用户输入的消息
      messages: [], // 消息列表
      userAvatar: '../../static/my_avatar.jpg', // 用户头像路径
      aiAvatar: '../../static/robot_square.png', // AI 头像路径
    };
  },
  methods: {
    // 调用 AI 接口
    async callAI(message) {
      const url = 'https://api.siliconflow.cn/v1/chat/completions'; // 添加接口地址
      const options = {
        method: 'POST',
        header: {
          Authorization: 'Bearer sk-roukuuwtzptzrwomfgaldlbsvgogfpuvumyetqzlcvjudgmc', // 替换为你的实际 API 密钥
          'Content-Type': 'application/json',
        },
        data: {
            messages: [
              
              { role: 'user', content: message }
            ],
          model: 'ft:LoRA/Qwen/Qwen2.5-7B-Instruct:cm3cthfxn01ev11v5fqml9ac6:peizhen9:dnqusutmjisamusyhlsg'
		  
        },
      };

      try {
        const result = await new Promise((resolve, reject) => {
          uni.request({
            url: url, // 确保 URL 正确传递
            ...options,
            success: (res) => resolve(res),
            fail: (err) => reject(err),
          });
        });

        if (result.statusCode === 200 && result.data) {
          const { choices } = result.data;
          if (choices && choices.length > 0) {
            return choices[0].message.content;
          } else {
            throw new Error('API 返回数据格式异常');
          }
        } else {
          throw new Error('请求失败，状态码：' + result.statusCode);
        }
      } catch (error) {
        console.error('调用 AI 接口失败', error);
        return 'AI 接口请求失败，请稍后重试。';
      }
    },

    // 发送消息
    async sendMessage() {
      if (this.inputMessage.trim() === '') return;

      // 添加用户发送的消息
      this.messages.push({ isSender: true, content: this.inputMessage });

      try {
        // 调用 AI 接口并获取回复
        const aiReply = await this.callAI(this.inputMessage);
        this.messages.push({ isSender: false, content: aiReply });
      } catch (error) {
        this.messages.push({
          isSender: false,
          content: 'AI 回复失败，请稍后再试。',
        });
      }

      // 清空输入框
      this.inputMessage = '';
    },
  },
};
</script>

<style scoped>
.chat-container {
  display: flex;
  flex-direction: column;
  height: 100vh;
  background-color: #f5f5f5;
}

.messages {
  flex: 1;
  overflow-y: auto;
  padding: 10px;
}

.message {
  display: flex;
  align-items: center;
  margin: 10px 0;
}

.message-sender {
  flex-direction: row-reverse;
}

.message-receiver {
  flex-direction: row;
}

.avatar {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  margin: 0 10px;
}

.bubble {
  max-width: 70%;
  padding: 10px;
  border-radius: 10px;
  background-color: #ffffff;
  box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.2);
}

.message-sender .bubble {
  background-color: #d1e7dd;
}

.input-container {
  display: flex;
  padding: 10px;
  background-color: #ffffff;
  border-top: 1px solid #ddd;
}

.input-box {
  flex: 1;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ddd;
  border-radius: 5px;
  outline: none;
}

.send-button {
  margin-left: 10px;
  padding: 2px 15px;
  font-size: 16px;
  color: #ffffff;
  background-color: #007bff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.send-button:hover {
  background-color: #0056b3;
}
</style>
