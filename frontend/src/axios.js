import axios from 'axios';

// 创建 Axios 实例
const instance = axios.create({
    baseURL: 'http://localhost:8080/api',  // 设置后端 API 的根路径
    timeout: 5000,                         // 请求超时时间
    headers: {
        'Content-Type': 'application/json'
    }
});

export default instance;
