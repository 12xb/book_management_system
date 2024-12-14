<template>
  <div id="app">
    <!-- 主体内容区域 -->
    <div v-if="$route.path === '/'" class="content">
      <h1>欢迎来到著作管理系统</h1>
      <p>在这里，您可以方便地管理您的著作相关信息。</p>

      <!-- 路由链接替换为 Vue Router 的 router-link -->
      <router-link to="/login" class="btn">登录</router-link>
      <router-link to="/register" class="btn">注册</router-link>
    </div>

    <!-- 路由展示区 -->
    <router-view />

    <!-- 页脚 -->
    <footer>
      <p>&copy; 2024 著作管理系统</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: 'App',
};
</script>

<style scoped>
/* 使整个页面的背景色和字体居中 */
#app {
  font-family: Arial, sans-serif;
  background-color: #f4f4f4;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
  text-align: center;
  margin: 0;
}

/* 内容部分居中 */
.content {
  max-width: 600px;
  padding: 20px;
}

/* 标题样式 */
h1 {
  color: #333;
  font-size: 2em;
  margin-bottom: 20px;
}

/* 描述文本样式 */
p {
  font-size: 1.2em;
  margin-bottom: 30px;
}

/* 按钮样式 */
.btn {
  display: inline-block;
  margin: 10px 0;
  padding: 10px 20px;
  background-color: #007BFF;
  color: white;
  text-decoration: none;
  border-radius: 5px;
  width: 200px;
  text-align: center;
}

.btn:hover {
  background-color: #0056b3;
}

/* 页脚样式 */
footer {
  margin-top: 30px;
  font-size: 0.9em;
  color: #666;
}
</style>
