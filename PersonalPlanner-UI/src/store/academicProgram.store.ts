import { defineStore } from 'pinia';
import { computed, ref } from 'vue';
import type { AcademicProgramDto } from '@/lib/generated/backend-api';
import { AcademicProgramControllerApi } from '@/lib/generated/backend-api';
import { apiConfig } from '@/util/ApiConfig';

const academicProgramApi = new AcademicProgramControllerApi(apiConfig);

export const useAcademicProgramStore = defineStore('academicProgram', () => {
    const programs = ref<Array<AcademicProgramDto> | undefined>(undefined);
    const isInitialised = computed(() => programs.value !== undefined);

    const init = async () => {
        if (isInitialised.value) {
            return;
        }

        programs.value = await academicProgramApi.findAllPrograms();
    };

    const createProgram = async (program: AcademicProgramDto): Promise<AcademicProgramDto> => {
        programs.value?.push(await academicProgramApi.createProgram(program));
    };

    const updateProgram = async (program: AcademicProgramDto): Promise<AcademicProgramDto> => {
        const updatedDto = await academicProgramApi.updateProgram(program);
        const savedProgram = programs.value?.find((value) => value.id === program.id);
        savedProgram.identifier = updatedDto.identifier;
        savedProgram.name = updatedDto.name;
        savedProgram.startingYear = updatedDto.startingYear;
        savedProgram.startingSemester = updatedDto.startingSemester;
        savedProgram.requiredEcts = updatedDto.requiredEcts;
    };

    const deleteProgram = async (id: string) => {
        const deletedProgram = await academicProgramApi.deleteProgram(id);
        programs.value = programs.value?.filter((value) => value.id !== deletedProgram.id);
    };

    return {
        programs,
        isInitialised,
        init,
        createProgram,
        updateProgram,
        deleteProgram
    };
});
