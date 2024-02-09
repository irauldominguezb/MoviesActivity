<template>
    <div class="container">
        <b-row>
            <b-col cols="12">
                <b-card class="m-4 shadow-lg">
                    <template slot="header">
                        <b-row class="pt-1">
                            <b-col md="6"><h5>Peliculas</h5></b-col>
                        </b-row>
                    </template>

                    <b-card-body
                        border-variant="white"
                        header-bg-variant="white"
                        header-text-variant="ssm"
                    >
                        <b-row>
                            <b-col cols="12" class="mb-3">
                                <b-row>
                                    <b-col cols="6" class="text-left">
                                        <b-button variant="primary" @click="showSaveModal()">
                                            <b-icon icon="plus"></b-icon> Agregar película
                                        </b-button>
                                    </b-col>
                                    <b-col cols="6" class="text-right">
                                        <b-form-group label-for="search">
                                            <b-input-group>
                                                <b-form-input
                                                    id="search"
                                                    type="search"
                                                    placeholder="Buscar..."
                                                ></b-form-input>
                                                <b-input-group-append>
                                                    <b-button variant="primary">Limpiar</b-button>
                                                </b-input-group-append>
                                            </b-input-group>
                                        </b-form-group>
                                    </b-col>
                                </b-row>
                                <b-row>
                                    <b-col cols="12" class="mt-2">
                                        <hr>
                                    </b-col>
                                    <b-col cols="12" md="6" lg="4" class="mt-2" v-for="(movie, index) in movies" :key="index">
                                        <b-card bg-variant="white" text-variant="black">
                                            <template #header>
                                                <b-row>
                                                    <b-col cols="12" md="6" lg="6" class="d-flex justify-content-start">
                                                        <b class="mt-1">{{ movie.title }}</b>
                                                    </b-col>
                                                    <b-col cols="12" md="6" lg="6" class="d-flex justify-content-end">
                                                        <b-button variant="white">
                                                            <b-icon icon="x" bg-color="white" scale="1.5"></b-icon>
                                                        </b-button>
                                                    </b-col>
                                                </b-row>
                                            </template>
                                            <b-card-text>
                                                <b-row>
                                                    <b-col cols="12">
                                                        <b>Director:</b> {{ movie.director }}
                                                    </b-col>
                                                    <b-col cols="12">
                                                        <b>Duration:</b> {{ movie.duration }}
                                                    </b-col>
                                                    <b-col cols="12">
                                                        <b>Genre:</b> {{ movie.genre }}
                                                    </b-col>
                                                </b-row>
                                            </b-card-text>
                                        </b-card>
                                    </b-col>
                                </b-row>
                            </b-col>
                        </b-row>
                    </b-card-body>
                </b-card>
                <SaveMovieVue/>
            </b-col>
        </b-row>
    </div>
</template>

<script>
import SaveMovieVue from './SaveMovie.vue'


export default {
    components: {
        SaveMovieVue
    },
    name: 'MoviesPage',
    data(){
        return {
            movies :[
                {
                    title: 'Titanic',
                    director: 'James Cameron',
                    duration: '3h 14m',
                    genre: 'Drama'
                },
                {
                    title: 'The Godfather',
                    director: 'Francis Ford Coppola',
                    duration: '2h 58m',
                    genre: 'Drama'
                },
                {
                    title: 'The Shawshank',
                    director: 'Frank Darabont',
                    duration: '2h 22m',
                    genre: 'Drama'
                }
            ]
        }
    },
    methods: {
        showSaveModal(){
            this.$bvModal.show("modal-save-movie");
        }
    }
}
</script>

<style>

</style>