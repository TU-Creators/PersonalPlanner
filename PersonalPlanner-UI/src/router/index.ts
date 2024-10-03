import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import { Routenames } from '@/router/Routenames';
import CalendarView from '@/views/CalendarView.vue';
import TodosView from '@/views/TodosView.vue';
import LvasView from '@/views/LvasView.vue';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: Routenames.HOME,
            component: HomeView
        },
        {
            path: '/lvas',
            name: Routenames.LVAS,
            component: LvasView
        },
        {
            path: '/todo',
            name: Routenames.TODOS,
            component: TodosView
        },
        {
            path: '/calendar',
            name: Routenames.CALENDAR,
            component: CalendarView
        }
    ]
});

export default router;
