<script setup lang="ts">
import type { MenuItem, MenuItemCommandEvent } from 'primevue/menuitem';
import router from '@/router';
import { Routenames } from '@/router/Routenames';
import { onMounted, ref } from 'vue';
import { useAuthenticationStore } from '@/store/authentication.store';
import type { User } from '@auth0/auth0-spa-js/src/global';
import Popover from 'primevue/popover';

const isAuthenticated = ref(false);
const user = ref<User | undefined>(undefined);
const authStore = useAuthenticationStore();
const userPopover = ref<typeof Popover | undefined>(undefined);

const menuitems: MenuItem[] = [
    {
        label: 'Home',
        icon: 'pi pi-home',
        routeName: Routenames.HOME,
        command: handleItemClick
    },
    {
        label: "LVA's",
        icon: 'pi pi-star',
        routeName: Routenames.LVAS,
        command: handleItemClick
    },
    {
        label: 'Calendar',
        icon: 'pi pi-calendar',
        routeName: Routenames.CALENDAR,
        command: handleItemClick
    },
    {
        label: "TODO's",
        icon: 'pi pi-check-square',
        routeName: Routenames.TODOS,
        command: handleItemClick
    }
];

function handleItemClick(event: MenuItemCommandEvent): void {
    router.push({ name: event.item.routeName });
}

const toggleUserPopover = (event: PointerEvent) => {
    userPopover?.value?.toggle(event);
};

onMounted(async () => {
    isAuthenticated.value = await authStore.isAuthenticated();
    user.value = await authStore.getUser();
});
</script>

<template>
    <Menubar :model="menuitems">
        <template #end>
            <div v-if="isAuthenticated" class="endbox">
                <Avatar :icon="user?.picture != null ? undefined : 'pi pi-user'" shape="circle" :image="user?.picture" @click="toggleUserPopover" />
                <Popover ref="userPopover">
                    <h3>{{ user?.name }}</h3>
                </Popover>
            </div>
            <div v-else class="endbox">
                <button label="Login" />
            </div>
        </template>
    </Menubar>
</template>

<style scoped lang="scss">
.endbox {
    display: flex;
    gap: 1rem;
    align-items: center;
}
</style>
