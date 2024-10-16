<script setup lang="ts">
import type { MenuItem, MenuItemCommandEvent } from 'primevue/menuitem';
import router from '@/router';
import { Routenames } from '@/router/Routenames';
import { ref } from 'vue';
import { useAuthenticationStore } from '@/store/authentication.store';
import Popover from 'primevue/popover';
import { storeToRefs } from 'pinia';

const authStore = useAuthenticationStore();
const { user } = storeToRefs(authStore);
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

const redirectToLogin = () => {
    router.push({ name: Routenames.LOGIN });
};

const redirectToLogout = () => {
    router.push({ name: Routenames.LOGOUT });
};

const printUser = () => {
    console.log(authStore.user);
};

const toggleUserPopover = (event: PointerEvent) => {
    userPopover?.value?.toggle(event);
};
</script>

<template>
    <Menubar :model="menuitems">
        <template #end>
            <div v-if="user !== undefined" class="endbox">
                <Avatar :icon="user?.picture != null ? undefined : 'pi pi-user'" shape="circle" :image="user?.picture" @click="toggleUserPopover" />
                <Popover ref="userPopover">
                    <h3>{{ user?.name }}</h3>
                    <Button label="Logout" @click="redirectToLogout" />
                    <Button label="Print user" @click="printUser" />
                </Popover>
            </div>
            <div v-else class="endbox">
                <Button label="Login" @click="redirectToLogin" />
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
