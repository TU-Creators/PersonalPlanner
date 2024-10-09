import type { RouteLocationNormalized, RouteLocationRaw, RouteRecordRaw } from 'vue-router';
import { createWebHistory } from 'vue-router';
import { Routenames } from '@/router/Routenames';
import HomeView from '@/views/HomeView.vue';
import LvasView from '@/views/LvasView.vue';
import TodosView from '@/views/TodosView.vue';
import CalendarView from '@/views/CalendarView.vue';
import { useAuthenticationStore } from '@/store/authentication.store';
import LoginView from '@/views/LoginView.vue';
import LogoutView from '@/views/LogoutView.vue';

export const routes = {
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
        },
        {
            path: '/login',
            name: Routenames.LOGIN,
            component: LoginView,
            beforeEnter: async (to: RouteLocationNormalized, from: RouteLocationNormalized): Promise<boolean | RouteLocationRaw> => {
                const authStore = useAuthenticationStore();
                await authStore.init();

                if ('code' in to.query && 'state' in to.query) {
                    await authStore.handleRedirectCallback();
                }

                if (await authStore.isAuthenticated()) {
                    return { name: Routenames.HOME };
                }

                await authStore.loginWithRedirect();
                return true;
            }
        },
        {
            path: '/logout',
            name: Routenames.LOGOUT,
            component: LogoutView,
            beforeEnter: async (to: RouteLocationNormalized, from: RouteLocationNormalized): Promise<boolean | RouteLocationRaw> => {
                const authStore = useAuthenticationStore();
                await authStore.init();

                if (!(await authStore.isAuthenticated())) {
                    return { name: Routenames.HOME };
                }

                await authStore.logout();
                return true;
            }
        }
    ] as RouteRecordRaw[]
};
