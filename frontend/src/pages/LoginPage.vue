<template>
    <div>
        <h2>登录</h2>
        <form @submit.prevent="login">
            <div>
                <label for="phone">手机号：</label>
                <input type="text" v-model="phone" required />
            </div>
            <div>
                <label for="password">密码：</label>
                <input type="password" v-model="password" required />
            </div>
            <button type="submit">登录</button>
        </form>
        <p>{{ errorMessage }}</p>
    </div>
</template>
  
<script>
import axios from '../axios';  // 引入 Axios 实例

export default {
    data() {
        return {
            phone: '',
            password: '',
            errorMessage: ''
        };
    },
    methods: {
        async login() {
            try {
                const response = await axios.post('/auth/login', {
                    phone: this.phone,
                    password: this.password
                });
                // 假设后端返回 token，将其存储在本地存储中
                localStorage.setItem('token', response.data.token);
                // 跳转到著作页面
                this.$router.push('/works');
            } catch (error) {
                this.errorMessage = '登录失败，请检查您的手机号或密码。';
            }
        }
    }
};
</script>
  
<style scoped>
/* 样式 */
form {
    display: flex;
    flex-direction: column;
    max-width: 300px;
    margin: 0 auto;
}

input {
    margin: 10px 0;
    padding: 10px;
    font-size: 1em;
}

button {
    padding: 10px;
    background-color: #007BFF;
    color: white;
    border: none;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}
</style>
  