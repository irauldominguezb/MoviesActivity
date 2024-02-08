<template>
  <b-modal id="modal-save-movie" no-close-on-backdrop centered no-close-on-esc size="md">
    <template v-slot:modal-header="{}">
        <h5>Agregar nueva película</h5>
    </template>
    <b-row>
        <b-col cols="12" class="mb-1">
            <b-form-group
                id="fieldset-movie-name"
                label-for="input-movie-title"
            >
                <label class="mandatory-field">Título: </label>
                <b-form-input
                    type="text"
                    label="input-movie-title"
                >
                </b-form-input>
            </b-form-group>
        </b-col>
    </b-row>
    <b-row>
        <b-col cols="12" md="6" lg="6" class="mb-1">
            <b-form-group
                id="fieldset-movie-director"
                label-for="input-movie-director"
            >
                <label class="mandatory-field">Director: </label>
                <b-form-input
                    type="text"
                    label="input-movie-director"
                >
                </b-form-input>
            </b-form-group>
        </b-col>
        <b-col cols="12" md="6" lg="6" class="mb-1">
            <b-form-group
                id="fieldset-movie-duration"
                label-for="input-movie-duration"
            >
                <label class="mandatory-field">Duración: </label>
                <b-form-input
                    type="text"
                    label="input-movie-duration"
                >
                </b-form-input>
            </b-form-group>
        </b-col>
    </b-row>
    <b-row>
        <b-col cols="12">
            <b-form-group
                id="fieldset-movie-genre"
                label-for="input-movie-genre"
            >
                <label class="mandatory-field">Genero: </label>
                <multiselect
                    :options="genres"
                    placeholder="Selecciona un género"
                    track-by="id"
                    label="name"
                    :close-on-select="true"
                >
                </multiselect>
            </b-form-group>
        </b-col>
    </b-row>
    <template slot="modal-footer">
        <b-row>
            <b-col 
                cols="12" 
                class="justify-content-center"
            >
                <b-button 
                    @click="closeModalSave()" 
                    class="m-1"
                >
                    Cancelar
                </b-button>
                <b-button 
                    @click="saveMovie()" 
                    variant="primary"
                >
                    Registrar
                </b-button>
            </b-col>
        </b-row>
    </template>
  </b-modal>
</template>

<script>
export default {
    name: 'SaveMovie',
    data() {
        return {
            movie: {},
            genres: [
                {
                    id: 1,
                    name: 'Horror'
                },
                {
                    id:2,
                    name: 'Comedy'
                }
            ]
        };
    },
    methods: {
        saveMovie() {
        console.log(this.movie);
        },
        closeModalSave(){
            this.$bvModal.hide("modal-save-movie");
        }
    },
}
</script>

<style scoped>
.mandatory-field::after{
    content: " * ";
    color: red
}
</style>