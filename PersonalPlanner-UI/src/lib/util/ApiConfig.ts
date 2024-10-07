import { Configuration } from '@/lib/generated/backend-api';

export const apiConfig = new Configuration({
    basePath: import.meta.env.PP_API_BASE_URL || 'http://localhost:8081/api'
});
