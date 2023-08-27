<template>
  <a-layout id="components-layout-demo-top-side-2">
    <header-view></header-view>
    <a-layout>
      <sidebar-view></sidebar-view>
      <a-layout-content :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }">
        <router-view></router-view>
<!--        这个的意思是动态变化-->
      </a-layout-content>
    </a-layout>
  </a-layout>
</template>
<script>
import { defineComponent } from 'vue';
import HeaderView from "@/components/header.vue";
import SidebarView from "@/components/sidebar.vue";
export default defineComponent({
  components: {
    SidebarView,
    HeaderView
  },
  name:"main-view",
  setup() {
    return {
    };
  },
});
</script>
<style>
#components-layout-demo-top-side-2 .logo {
  float: left;
  width: 120px;
  height: 31px;
  margin: 16px 24px 16px 0;
  background: rgba(255, 255, 255, 0.3);
}

.ant-row-rtl #components-layout-demo-top-side-2 .logo {
  float: right;
  margin: 16px 0 16px 24px;
}

.site-layout-background {
  background: #fff;
}
</style>