<template>
    <div>
        <h2>注册</h2>
        <form @submit.prevent="register">
            <div>
                <label for="phone">手机号：</label>
                <input type="text" v-model="phone" required />
            </div>
            <div>
                <label for="email">邮箱：</label>
                <input type="email" v-model="email" required />
            </div>
            <div>
                <label for="password">密码：</label>
                <input type="password" v-model="password" required />
            </div>
            <div>
                <label for="confirmPassword">确认密码：</label>
                <input type="password" v-model="confirmPassword" required />
            </div>
            <button type="submit">注册</button>
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
            email: '',
            password: '',
            confirmPassword: '',
            errorMessage: ''
        };
    },
    methods: {
        async register() {
            if (this.password !== this.confirmPassword) {
                this.errorMessage = '两次输入的密码不一致！';
                return;
            }
            try {
                await axios.post('/auth/register', {
                    phone: this.phone,
                    email: this.email,
                    password: this.password
                });
                // 注册成功后跳转到登录页面
                this.$router.push('/login');
            } catch (error) {
                this.errorMessage = '注册失败，请稍后再试。';
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
    background-color: #28a745;
    color: white;
    border: none;
    cursor: pointer;
}

button:hover {
    background-color: #218838;
}
</style>
  