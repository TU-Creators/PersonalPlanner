import './assets/base.scss';

import { createApp } from 'vue';
import { createPinia } from 'pinia';
import PrimeVue from 'primevue/config';
import Aura from '@primevue/themes/aura';

import App from './App.vue';
import router from './router';
import { definePreset } from '@primevue/themes';

const app = createApp(App);

app.use(createPinia());
app.use(router);

const adaptedPreset = definePreset(Aura, {
    semantic: {
        primary: {
            50: '{violet.50}',
            100: '{violet.100}',
            200: '{violet.200}',
            300: '{violet.300}',
            400: '{violet.400}',
            500: '{violet.500}',
            600: '{violet.600}',
            700: '{violet.700}',
            800: '{violet.800}',
            900: '{violet.900}',
            950: '{violet.950}'
        }
    }
});

app.use(PrimeVue, {
    theme: {
        preset: adaptedPreset,
        options: {
            // darkModeSelector: '.my-app-dark'
        }
    }
});

app.mount('#app');
