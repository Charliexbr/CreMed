<template>
	<view class="drag-content" @click.stop="dragClick" @touchstart.capture="touchstart"
		@touchend.capture="touchend" @touchmove.capture="touchmove"
		:style="{left:left + 'px',top:top + 'px',backgroundColor:background,width:dragSize + 'rpx',height:dragSize + 'rpx'}">
		<view class="drag-stop">
			<image :src="image" mode="widthFix" :style="{width:imageWidth}" v-if="image"></image>
		</view>	
		
	</view>
</template>

<script>
	export default {
		name: 'x-drag',
		data() {
			return {
				left: '280',
				top: '500',
				isdrag: false,
				NowLeft: '',
				disX: '',
				NowTop: '',
				disY: ''
			};
		},
		mounted() {
			this.top = this.creatTop;
			this.left = this.creatLeft;
		},
		props: {
			dragSize: {
				type: String,
				default: '120'
			},
			creatTop: {
				type: String,
				default: '600'
			},
			creatLeft: {
				type: String,
				default: '280'
			},
			image: {
				type: String,
				default: ''
			},
			background: {
				type: String,
				default: 'rgb(56, 128, 255)'
			},
			imageWidth: {
				type: String,
				default: '80'
			}
		},
		methods: {
			dragClick() {
				this.$emit('dragClick')
			},
			touchstart(e) {
				e.preventDefault()
				let that = this;
				this.isdrag = true;
				this.NowLeft = parseInt(that.left);
				this.NowTop = parseInt(that.top);
				this.disX = e.touches[0].pageX;
				this.disY = e.touches[0].pageY;
				return false;
			},
			touchend(e) {
				e.preventDefault()
				this.isdrag = false;
			},
			touchmove(e) {
				e.preventDefault()
				if (this.isdrag) {
					this.left = this.NowLeft + e.touches[0].pageX - this.disX;
					this.top = this.NowTop + e.touches[0].pageY - this.disY;
					return false;
				}
			}
		}
	}
</script>

<style scoped>
	.drag-content {
		width: 120rpx;
		height: 120rpx;
		border-radius: 50%;
		background-color: rgb(56, 128, 255);
		position: fixed;
		display: flex;
		justify-content: center;
		align-items: center;
		box-shadow: rgba(0, 0, 0, 0.2) 0px 4px 16px 0px;
		z-index: 5;
		overflow: hidden;
	}

	.drag-content:active {
		transform: scale(.95);
		transition: all .2s;
	}
	.drag-stop{
		width: 100%;
		height: 100%;
	}

	.drag-content image {
		width: 40%;
	}
</style>