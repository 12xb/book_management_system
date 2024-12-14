import { createRouter, createWebHistory } from 'vue-router';
import LoginPage from '../pages/LoginPage.vue';
import RegisterPage from '../pages/RegisterPage.vue';
import WorksPage from '../pages/WorksPage.vue';
import EditWorkPage from '../pages/EditWorkPage.vue';

const routes = [
    {
        path: '/login',
        name: 'LoginPage',
        component: LoginPage,
    },
    {
        path: '/register',
        name: 'RegisterPage',
        component: RegisterPage,
    },
    {
        path: '/works',
        name: 'WorksPage',
        component: WorksPage,
    },
    {
        path: '/works/edit/:id',
        name: 'EditWorkPage',
        component: EditWorkPage,
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
