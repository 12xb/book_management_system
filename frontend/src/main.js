import { createApp } from 'vue';
import App from './App.vue';  // 导入主应用组件
import router from './router'; // 导入 Vue Router

// 创建 Vue 应用实例，并使用 Vue Router 插件
createApp(App)
    .use(router)  // 使用 Vue Router
    .mount('#app'); // 挂载到页面上的 #app 元素
