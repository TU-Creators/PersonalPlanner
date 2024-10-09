<script setup lang="ts">
import Container from '@/components/Container.vue';
import { UserControllerApi } from '@/lib/generated/backend-api';
import { apiConfig } from '@/util/ApiConfig';
import { useAuthenticationStore } from '@/store/authentication.store';
import { ref } from 'vue';

const api = new UserControllerApi(apiConfig);
const authenticationStore = useAuthenticationStore();
const isAuth = ref<boolean | undefined>(undefined);

async function loadData(): Promise<void> {
    console.log(await api.getUsers());
}

async function checkAuth(): Promise<void> {
    isAuth.value = await authenticationStore.isAuthenticated();
}

async function login(): Promise<void> {
    await authenticationStore.auth0?.loginWithPopup();
}

async function logout(): Promise<void> {
    await authenticationStore.logout();
}
</script>

<template>
    <Container>
        <Button label="Test" @click="loadData" />
        <Button label="Login" @click="login" />
        <Button label="Logout" @click="logout" />
        <Button label="checkAuth" @click="checkAuth" />
        {{ isAuth }}
        <Button label="printUser" @click="async () => console.log(await authenticationStore.getUser())" />
    </Container>
</template>

<style scoped lang="scss"></style>
