<template>
    <div class="container">
        <b-row>
            <b-col cols="12">
                <b-card class="m-4 shadow-lg">
                    <template slot="header" >
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
                                    <b-col md="6" class="d-flex justify-content-between">
                                        <b-button variant="primary" @click="showSaveModal()" >
                                            <b-icon icon="plus"></b-icon> <label class="">Agregar película</label>
                                        </b-button>
                                    </b-col>
                                    <b-col md="6" class="text-right">
                                        <b-form-group label-for="search">
                                            <b-input-group>
                                                <b-form-input
                                                    id="search"
                                                    type="search"
                                                    placeholder="Buscar..."
                                                ></b-form-input>
                                                <b-input-group-append class="show-button-with-media-query">
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
                                        <div v-if="movies.length != 0">
                                            <b-card header-bg-variant="primary" bg-variant="white" text-variant="white" class="hover">
                                                <template #header>
                                                    <b-row>
                                                        <b-col cols="12" md="6" lg="6" class="d-flex justify-content-start">
                                                            <b class="mt-1">{{ movie.name }}</b>
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
                                                        <b-col cols="12" class="text-black">
                                                            <b>Director:</b> <label>{{ movie.director }}</label>
                                                        </b-col>
                                                        <b-col class="text-black"  cols="12">
                                                            <b>Duration:</b> {{ movie.duration }}
                                                        </b-col>
                                                        <b-col class="text-black" cols="12">
                                                            <b>Genre:</b> {{ movie.gender.name }}
                                                        </b-col>
                                                    </b-row>
                                                </b-card-text>
                                            </b-card>
                                        </div>
                                    </b-col>
                                    <div v-show="movies.length === 0">
                                        <b-row>
                                            <b-col cols="12" class="d-flex justify-content-center">
                                                <b-alert show variant="primary">
                                                    No hay películas registradas
                                                </b-alert>
                                            </b-col>
                                        </b-row>
                                    </div>
                                </b-row>
                                <b-row>
                                    <b-col cols="12" class="mt-4 ">
                                        <b-row>
                                            <b-col cols ="6" md="4" class="align-self-center">
                                                <h6 class="text-secondary justify-content-left">
                                                    Total de registros: {{ rows }}
                                                </h6>
                                            </b-col>
                                            <b-col cols ="6" md="4" class="d-flex justify-content-end order-md-5 align-self-center mb-4">
                                                <div class="d-inline justify-content-center align-items-right">
                                                    <b-form-group
                                                        class="text-right"
                                                        label-cols="6"
                                                        label-for="pages-select"
                                                        label-size="md"
                                                        style="font-weight: bold"
                                                    >
                                                        
                                                        <b-input-group size="lg">
                                                            <b-form-select
                                                                id="pages-select"
                                                                style="border: solid 1px gray;"
                                                                v-model="perPage"
                                                                @change="getMovies()"
                                                            >
                                                            <template #first>
                                                                <option value="5">5</option>
                                                                <option value="10">10</option>
                                                                <option value="15">15</option>
                                                                <option value="20">20</option>
                                                            </template>
                                                            </b-form-select>
                                                        </b-input-group>
                                                    </b-form-group>
                                                </div>
                                            </b-col>
                                            <b-col cols="12"  md="4"  class="d-flex justify-content-center order-md-3 mt-4 align-self-center">
                                                <b-pagination
                                                    v-model="currentPage"
                                                    @input="getMovies()"
                                                    :total-rows="rows"
                                                    :per-page="perPage"
                                                    size="md"
                                                ></b-pagination>
                                            </b-col>
                                        </b-row>
                                    </b-col>
                                </b-row>
                            </b-col>
                        </b-row>
                    </b-card-body>
                </b-card>
                <SaveMovieVue
                    :getMovies="getMovies"
                />
            </b-col>
        </b-row>
    </div>
</template>

<script>
import SaveMovieVue from './SaveMovie.vue'
import movieServices from '../../services/Movie'

export default {
    components: {
        SaveMovieVue
    },
    name: 'MoviesPage',
    data(){
        return {
            movies :[],
            currentPage: 1,
            perPage: 5,
            rows: 0
        }
    },
    methods: {
        showSaveModal(){
            this.$bvModal.show("modal-save-movie");
        },
        async getMovies(){
            try {
                const pagination = {
                    size: this.perPage,
                    page: (this.currentPage-1)
                }
                const {status,data ,data: {content, totalElements} } = await movieServices.getMovies(pagination)
                if(status === 200){
                    console.log("data",data)
                    console.log("content",content)
                    this.movies = content
                    console.log("totalElements",totalElements)
                    this.rows = totalElements
                }
            } catch (error) {
                console.log("error",error)
            }
        }
    },
    mounted(){
        this.getMovies()
    }
    
}
</script>

<style scoped>
.hover:hover{
    cursor: pointer;
    box-shadow: 2px -2px 58px 15px rgba(196,188,196,0.6);;
}

.show-button-with-media-query {
    @media (max-width: 768px){
        display: none;
    }
}

#search{
    @media (max-width: 766px){
        margin-top: 10px;
        width: 100%;
        border-radius: 3px;
    }
}


.show-label{
    @media (max-width: 768px){
        display: none;
        border-radius: 100%;
    }
}



</style>