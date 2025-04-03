"use strict";
const common_vendor = require("../../../../common/vendor.js");
const uni_modules_limeFab_components_lFab_props = require("./props.js");
const uni_modules_limeShared_unitConvert_index = require("../../../lime-shared/unitConvert/index.js");
const uni_modules_limeShared_addUnit_index = require("../../../lime-shared/addUnit/index.js");
const uni_modules_limeShared_getRect_vue = require("../../../lime-shared/getRect/vue.js");
const uni_modules_limeShared_closest_index = require("../../../lime-shared/closest/index.js");
const name = "l-fab";
const _sfc_main = common_vendor.defineComponent({
  name,
  props: uni_modules_limeFab_components_lFab_props.FloatingBubbleProps,
  emits: ["click", "update:offset", "change"],
  setup(props, { emit }) {
    const context = common_vendor.getCurrentInstance();
    const { windowWidth, windowHeight } = common_vendor.index.getSystemInfoSync();
    const root = common_vendor.reactive({
      width: 0,
      height: 0
    });
    const state = common_vendor.reactive({
      ox: 0,
      oy: 0,
      x: 0,
      y: 0,
      animation: false,
      width: 0,
      height: 0
    });
    const dragging = common_vendor.ref(false);
    const gap = common_vendor.computed(() => uni_modules_limeShared_unitConvert_index.unitConvert(props.gap));
    const boundary = common_vendor.computed(() => ({
      top: 0,
      left: 0,
      right: windowWidth - state.height - gap.value,
      bottom: windowHeight - state.width - gap.value
    }));
    const rootStyle = common_vendor.computed(() => {
      const style = {
        width: uni_modules_limeShared_addUnit_index.addUnit(windowWidth - gap.value * 2),
        height: uni_modules_limeShared_addUnit_index.addUnit(windowHeight - gap.value * 2),
        left: uni_modules_limeShared_addUnit_index.addUnit(gap.value),
        bottom: uni_modules_limeShared_addUnit_index.addUnit(gap.value)
      };
      return style;
    });
    const direction = common_vendor.computed(() => {
      const obj = {
        x: "horizontal",
        y: "vertical",
        xy: "all"
      };
      return obj[props.axis] || "none";
    });
    const styles = common_vendor.computed(() => {
      uni_modules_limeShared_addUnit_index.addUnit(state.x);
      uni_modules_limeShared_addUnit_index.addUnit(state.y);
      const style = {};
      if (!state.animation) {
        style.opacity = 0;
      }
      if (props.size) {
        style.height = style.width = uni_modules_limeShared_addUnit_index.addUnit(props.size);
      }
      if (props.bgColor) {
        style["background"] = props.bgColor;
      }
      return style;
    });
    const updateState = () => {
      const { width, height } = root;
      const { offset } = props;
      if (dragging.value)
        return;
      Object.assign(state, {
        ox: offset[0] > -1 ? offset[0] : windowWidth - width - gap.value,
        oy: offset[1] > -1 ? offset[1] : windowHeight - height - gap.value
      });
      Object.assign(state, {
        x: offset[0] > -1 ? offset[0] : windowWidth - width - gap.value,
        y: offset[1] > -1 ? offset[1] : windowHeight - height - gap.value,
        width,
        height
      });
    };
    const onTouchStart = () => {
      dragging.value = true;
    };
    const onTouchMove = ({ detail }) => {
      if (!dragging.value)
        return;
      const { x, y } = detail;
      state.ox = x;
      state.oy = y;
      emit("update:offset", [x, y]);
      emit("change", [x, y]);
    };
    const magnetic = (boundary2, traget, axis) => {
      if (props.magnetic === axis) {
        const next = uni_modules_limeShared_closest_index.closest(boundary2, traget);
        const axis2 = axis == "x" ? "y" : "x";
        const current = state["o" + axis2];
        state[axis] = next - 1e-3;
        state[axis2] = current - 1e-3;
        setTimeout(() => {
          state[axis] = next;
          state[axis2] = current;
          const e = [state.x, state.y];
          emit("update:offset", e);
          emit("change", e);
        }, 50);
      }
    };
    const onTouchEnd = () => {
      dragging.value = false;
      setTimeout(() => {
        magnetic([boundary.value.left, boundary.value.right], state.ox, "x");
        magnetic([boundary.value.top, boundary.value.bottom], state.oy, "y");
      }, 100);
    };
    const onClick = (e) => {
      emit("click", e);
    };
    const stopWatch = common_vendor.watch(
      [() => props.gap, () => props.offset],
      () => updateState()
      // { deep: true }
    );
    common_vendor.onMounted(() => {
      setTimeout(() => {
        uni_modules_limeShared_getRect_vue.getRect(`.${name}`, context == null ? void 0 : context.proxy).then((res) => {
          root.width = res.width;
          root.height = res.height;
          updateState();
          state.animation = true;
        });
      }, 100);
    });
    common_vendor.onUnmounted(() => {
      stopWatch();
    });
    return {
      styles,
      onTouchStart,
      onTouchEnd,
      onClick,
      state,
      rootStyle,
      onTouchMove,
      direction
    };
  }
});
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return common_vendor.e({
    a: !_ctx.state.animation
  }, !_ctx.state.animation ? {
    b: common_vendor.s(_ctx.styles)
  } : {}, {
    c: _ctx.state.animation
  }, _ctx.state.animation ? {
    d: _ctx.direction,
    e: common_vendor.s(_ctx.styles),
    f: _ctx.state.x,
    g: _ctx.state.y,
    h: _ctx.state.animation,
    i: common_vendor.o((...args) => _ctx.onClick && _ctx.onClick(...args)),
    j: common_vendor.o((...args) => _ctx.onTouchStart && _ctx.onTouchStart(...args)),
    k: common_vendor.o((...args) => _ctx.onTouchEnd && _ctx.onTouchEnd(...args)),
    l: common_vendor.o((...args) => _ctx.onTouchEnd && _ctx.onTouchEnd(...args)),
    m: common_vendor.o((...args) => _ctx.onTouchStart && _ctx.onTouchStart(...args)),
    n: common_vendor.o((...args) => _ctx.onTouchEnd && _ctx.onTouchEnd(...args)),
    o: common_vendor.o((...args) => _ctx.onTouchMove && _ctx.onTouchMove(...args))
  } : {}, {
    p: common_vendor.s(_ctx.rootStyle)
  });
}
const Component = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render]]);
wx.createComponent(Component);
