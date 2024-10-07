<script setup lang="ts">
import Container from '@/components/Container.vue';
import { UserControllerApi } from '@/lib/generated/backend-api';
import { apiConfig } from '@/lib/util/ApiConfig';

const api = new UserControllerApi(apiConfig);

async function loadData(): Promise<void> {
    console.log(await api.getUsers());
}

</script>

<template>
    <Container>
        <Button label="Test" @click="loadData" />
    </Container>
</template>

<style scoped lang="scss"></style>
