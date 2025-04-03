<template>
	<view>
		<view class="cell-box" v-for="(item, index) in clients" :key="index">
			<view class="weui-cell">
				<view class="weui-cell__bd">
					<view>
						<text style="font-weight: bold">{{ item.name }}</text>
					</view>
					<view>
						<text :class="'sext' + item.sex">{{ item.sex == 1 ? '男' : '女' }}</text>
						<text style="margin-left: 10rpx">{{ item.job }}</text>
						<text style="margin-left: 10rpx">{{ item.trait }}</text>
					</view>
				</view>
				<view class="weui-cell__ft">
					<text v-if="act == 'select'" @click="onClientSelected(item)" style="
		                display: inline-block;
		                padding: 15rpx 30rpx;
		                border: 1rpx solid #0bb584;
		                color: #0bb584;
		                font-weight: bold;
		                border-radius: 10rpx;
		                font-size: 28rpx;
		                overflow: hidden;
		            ">
						选择
					</text>
					<text v-else @click="onClientSelected(item)" :data-id="item.id" style="
		                display: inline-block;
		                padding: 15rpx 30rpx;
		                border: 1rpx solid #eeeeee;
		                color: #0bb584;
		                border-radius: 10rpx;
		                font-size: 28rpx;
		                overflow: hidden;
		            ">
						选择
					</text>
				</view>
			</view>
		</view>
	</view>
</template>

<script setup>
	import {
		onLoad
	} from "@dcloudio/uni-app"
	import {
		ref,
		reactive,
		computed,
		toRaw
	} from "vue"
	const app = getApp()
	const clients = ref([]) // 服务对象列表
	const act = ref('') // 页面来源标识

	onLoad((option) => {
		act.value = option.act // 页面来源标识
		// 根据url中的参数显示不同的页面标题文本
		    // 接收 orderId 参数
		    const orderId = option.OrderId ? Number(option.OrderId) : null;
		    console.log("Received orderId:", orderId);
			console.log("Type of orderId:", typeof orderId);
		
		    // 存储 orderId 到页面状态或全局状态
		    if (orderId) {
		        app.globalData.orderId = orderId;
		    }
		if (option.act == 'select') {
			uni.setNavigationBarTitle({
				title: '请选择服务对象'
			})
		} else {
			uni.setNavigationBarTitle({
				title: '服务人员选择'
			})
		}
		// 获取服务对象列表
		app.globalData.utils.request2({
			url: '/User/clients',
			success: (res) => {
				clients.value = res.data.data.clients
				// console.log(res.data.data.clients, 'res');
			}
		})
	})
	// 监听选中的服务对象
	const onClientSelected = (item) => {
		// 从页面或全局状态中获取 orderId
		const orderId = app.globalData.orderId || null;

		if (!orderId) {
			console.error("Order ID is missing!");
			return;
		}

		// 构造请求数据
		const requestData = {
			orderId: orderId,
			clientName: item.name,
		};

		// 发送请求到接口
		app.globalData.utils.request2({
			url: '/Order/update', // 接口地址
			method: 'POST', // 使用 POST 方法
			data: requestData, // 发送的数据
			success: (res) => {
				console.log("Order updated successfully:", res);

				// 如果接口返回成功，回到上一个页面
				uni.switchTab({
					url: '../order/index',
				});
			},
			fail: (err) => {
				console.error("Failed to update order:", err);
				uni.showToast({
					title: "更新订单失败",
					icon: "none",
				});
			},
		});
	};

	// 移出服务对象
	const removeClient = (item) => {

	}
</script>

<style>
	@import 'index.css';
</style>