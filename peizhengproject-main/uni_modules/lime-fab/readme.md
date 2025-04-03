# lime-fab 浮动气泡
- lime-fab 悬浮在页面边缘并可拖拽可点击的汽泡型悬浮按钮，自主吸附，兼容uniapp/uniappx(web,ios,安卓)，vue2需要配置vue/composition-api

## 代码演示

### 基础用法

浮动气泡默认展示在右下角，并允许在 y 轴方向上下拖拽。

```html
<l-fab @click="onClick" />
```

```js
const onClick = () => {
    console.log('点击气泡')
};
```

### 自由拖拽和磁吸

允许 x 和 y 轴方向拖拽，吸附到 x 轴方向最近一边。

```html
<l-fab
  axis="xy"
  magnetic="x"
  @change="onOffsetChange"
/>
```

```js
const onOffsetChange = (offset) => {
    uni.showToast(offset[0] + '__' + offset[1]);
};
```

### 使用 v-model
- offset为数值数组，`offset[0]`为x，`offset[1]`为y
- vue3 使用 `v-model:offset` 控制位置。
- vue2 使用 `:offset.sync` 控制位置。

```html
// vue3
<l-fab v-model:offset="offset" axis="xy" />
// vue2
<l-fab :offset.sync="offset" axis="xy" />
```

```js
 data() {
	 return {
		 // [x, y]
		 offset: [200, 400]
	 }
 }
```


### 查看示例
- 导入后直接使用这个标签查看演示效果

```html
<!-- // 代码位于 uni_modules/lime-fab/compoents/lime-fab -->
<lime-fab />
```


### 插件标签
- 默认 l-fab 为 component
- 默认 lime-fab 为 demo

### 关于vue2的使用方式
- 插件使用了`composition-api`, 如果你希望在vue2中使用请按官方的教程[vue-composition-api](https://uniapp.dcloud.net.cn/tutorial/vue-composition-api.html)配置
- 关键代码是: 在main.js中 在vue2部分加上这一段即可.
```js
// vue2
import Vue from 'vue'
import VueCompositionAPI from '@vue/composition-api'
Vue.use(VueCompositionAPI)
```



## API

### Props

| 参数 | 说明 | 类型 | 默认值 |
| --- | --- | --- | --- |
| v-model:offset | 控制气泡位置 | _number[]_ | `默认右下角坐标` |
| axis | 拖拽的方向，`xy` 代表自由拖拽，`lock` 代表禁止拖拽 | _'x' \| 'y' \| 'xy' \| 'lock'_ | `y` |
| magnetic | 自动磁吸的方向 | _'x' \| 'y'_ | - |
| gap | 气泡与窗口的最小间距，单位为 `px` | _'number' \| 'string'_| `24` |

### Events

| 事件          | 说明                         | 回调参数                 |
| ------------- | ---------------------------- | ------------------------ |
| click         | 点击组件时触发               | _MouseEvent_             |
| change | 由用户拖拽导致位置改变后触发 | _{x: string, y: string}_ |

### Slots

| 名称    | 说明               |
| ------- | ------------------ |
| default | 自定义气泡显示内容 |



## 主题定制

### 样式变量
- nvue不支持
组件提供了下列 CSS 变量，可用于自定义样式

| 名称                              | 默认值                     | 描述 |
| --------------------------------- | -------------------------- | ---- |
| --l-fab-size        | _48px_                     | -    |
| --l-fab-initial-gap | _24px_                     | -    |
| --l-fab-icon-size   | _28px_                     | -    |
| --l-fab-background  | _#1677ff_ | -    |
| --l-fab-color       | _white_  | -    |
| --l-fab-z-index     | _999_                      | -    |
