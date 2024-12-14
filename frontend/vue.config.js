const { defineConfig } = require('@vue/cli-service')
module.exports = {
  devServer: {
    historyApiFallback: true, // 确保前端路由刷新时不会返回 404
    port: 8082, // 设置你的开发服务器端口，如果需要的话
    open: true, // 启动项目后自动打开浏览器
    proxy: {
      '/api': {
        target: 'http://localhost:8080', // 将 API 请求代理到你的后端地址
        changeOrigin: true,
        pathRewrite: { '^/api': '' }
      }
    }
  }
};
