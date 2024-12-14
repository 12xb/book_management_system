<template>
    <div>
        <!-- 编辑著作页面内容 -->
        <h1>编辑著作</h1>
        <form @submit.prevent="updateWork">
            <input v-model="workTitle" type="text" placeholder="著作名称" required />
            <input v-model="publisher" type="text" placeholder="出版社" required />
            <input v-model="wordCount" type="number" placeholder="字数" required />
            <button type="submit">更新著作</button>
        </form>
    </div>
</template>
  
<script>
export default {
    name: 'EditWorkPage',  // 修改为多词组件名

    data() {
        return {
            workTitle: '',
            publisher: '',
            wordCount: ''
        };
    },

    methods: {
        async updateWork() {
            // 执行更新著作逻辑
            console.log('更新著作:', this.workTitle, this.publisher, this.wordCount);
            // 例如调用 API 进行更新
        }
    }
};
</script>
  
<style scoped>
/* 样式 */
form {
    display: flex;
    flex-direction: column;
    max-width: 400px;
    margin: 0 auto;
}

input {
    margin: 10px 0;
    padding: 10px;
    font-size: 1em;
}

button {
    padding: 10px;
    background-color: #ffc107;
    color: white;
    border: none;
    cursor: pointer;
}

button:hover {
    background-color: #e0a800;
}
</style>
  