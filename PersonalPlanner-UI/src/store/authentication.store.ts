import { defineStore } from 'pinia';
import { Auth0Client, createAuth0Client, type RedirectLoginResult } from '@auth0/auth0-spa-js';
import { computed, ref } from 'vue';
import type { User } from '@auth0/auth0-spa-js/src/global';

export const useAuthenticationStore = defineStore('authentication', () => {
    const auth0 = ref<Auth0Client | undefined>(undefined);

    const isInitialised = computed(() => auth0.value !== undefined);

    const init = async () => {
        if (isInitialised.value) {
            return;
        }

        auth0.value = await createAuth0Client({
            domain: import.meta.env.VITE_PP_AUTH0_DOMAIN,
            clientId: import.meta.env.VITE_PP_AUTH0_CLIENT_ID,
            authorizationParams: {
                redirect_uri: import.meta.env.VITE_PP_AUTH0_CALLBACK_URL
            }
        });
    };

    const isAuthenticated = async (): Promise<boolean> => {
        await init();

        if (auth0.value == null) {
            return false;
        }

        return auth0.value.isAuthenticated();
    };

    const loginWithRedirect = async (): Promise<void> => {
        await auth0.value?.loginWithRedirect();
    };

    const handleRedirectCallback = async (): Promise<RedirectLoginResult | undefined> => {
        return auth0.value?.handleRedirectCallback();
    };

    const getUser = async (): Promise<User | undefined> => {
        return auth0.value?.getUser();
    };

    const logout = async (): Promise<void> => {
        return auth0.value?.logout();
    };

    return {
        auth0,
        init,
        isAuthenticated,
        loginWithRedirect,
        handleRedirectCallback,
        getUser,
        logout,
        isInitialised
    };
});
