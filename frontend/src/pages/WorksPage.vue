<template>
    <div>
        <h2>著作列表</h2>
        <ul>
            <li v-for="work in works" :key="work.id">{{ work.title }}</li>
        </ul>
    </div>
</template>
  
<script>
import axios from '../axios';  // 引入 Axios 实例

export default {
    data() {
        return {
            works: []
        };
    },
    async mounted() {
        try {
            // 从本地存储中获取 token
            const token = localStorage.getItem('token');
            const response = await axios.get('/works', {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            this.works = response.data;
        } catch (error) {
            console.error('获取著作列表失败:', error);
        }
    }
};
</script>
  
  
<style scoped>
/* 样式 */
ul {
    list-style-type: none;
    padding: 0;
}

li {
    display: flex;
    justify-content: space-between;
    margin-bottom: 10px;
}

button {
    margin-left: 10px;
    padding: 5px 10px;
    background-color: #007BFF;
    color: white;
    border: none;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}
</style>
  