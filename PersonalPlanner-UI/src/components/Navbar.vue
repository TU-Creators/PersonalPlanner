<script setup lang="ts">
import type { MenuItem, MenuItemCommandEvent } from 'primevue/menuitem';
import router from '@/router';
import { Routenames } from '@/router/Routenames';

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
</script>

<template>
    <Menubar :model="menuitems">
        <template #end>
            <div class="endbox">
                <Avatar icon="pi pi-user" shape="circle" />
            </div>
        </template>
    </Menubar>
</template>

<style scoped lang="scss">
.endbox {
    display: flex;
    gap: 1rem;
}
</style>
